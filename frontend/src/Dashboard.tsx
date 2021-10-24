import React, {useEffect, useRef, useState} from 'react'
import {ABC} from "./LoginEvents";

export type LoginEvent = {
	ip: string
	user: string
	password: string
}



export const Dashboard = () => {

	const [listening, setListening] = useState(false);
	//const [cpuUsage, setcpuUsage] = useState(0);
	//const [memoryUsage, setmemoryUsage] = useState(0);

	let eventSource: EventSource = useRef<EventSource>(new EventSource("http://localhost:8080/events/login"));

	const itemsRef = useRef<LoginEvent[]>([]);

const loginEvents: LoginEvent[] = []

	useEffect(() => {
		if (!listening) {
			eventSource.onmessage = (event: any) => {
				const loginEvent = JSON.parse(event.data);
				//setit(loginEvent)
				loginEvents.push(loginEvent)
				itemsRef.current = loginEvents

				console.table(loginEvents)
			}
			eventSource.onerror = (err: any) => {
				console.error("EventSource failed:", err);
				eventSource?.close();
			}
			setListening(true)
		}
		return () => {
			eventSource?.close();
			console.log("event closed")
		}

	}, [])

	return (
			<div style={{ "marginTop": "20px", "textAlign": "center" }}>
				<h1>Dashboard</h1>

				<ABC events={itemsRef.current}></ABC>

			</div>
	)
}
