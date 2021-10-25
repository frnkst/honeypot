import React, {MutableRefObject, useEffect, useRef, useState} from 'react'
import {SSEProvider, useSSE} from "react-hooks-sse";

export type LoginEvent = {
	ip: string
	user: string
	password: string
}

const loginEvents: LoginEvent[]= [];

const Comments = () => {
	const [listening, setListening] = useState(false);
	const [data, setData] = useState<LoginEvent[]>([]);
	let eventSource: EventSource | undefined = undefined;

	useEffect(() => {
		if (!listening) {
			eventSource = new EventSource("http://localhost:8080/events/login");

			eventSource.onopen = (event) => {
				console.log("connection opened")
			}

			eventSource.onmessage = (event) => {
				console.log("result", event.data);
				setData(old => [...old, event.data])
			}

			/*
			eventSource.onerror = (event) => {
				console.log(event.target.readyState)
				if (event.target.readyState === EventSource.CLOSED) {
					console.log('eventsource closed (' + event.target.readyState + ')')
				}
				eventSource.close();
			}
			 */

			setListening(true);
		}

		return () => {
			eventSource?.close();
			console.log("eventsource closed")
		}

	}, [])

	return (
			<>
					Received Data
					{data.map((d, i) =>
							<span key={i}>{d}</span>
					)}

			</>
	);
};


export const Dashboard = () => {
	return (
			<div style={{ "marginTop": "20px", "textAlign": "center" }}>
				<h1>Dashboard</h1>

				<SSEProvider endpoint="http://localhost:8080/events/login">
					<Comments/>
				</SSEProvider>
			</div>
	)
}
