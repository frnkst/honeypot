import React, {useEffect, useState} from "react";

export type LoginEvent = {
	ip: string
	port: string
	user: string
	password: string
}

export const LoginEvents = () => {
	const [listening, setListening] = useState(false);
	const [data, setData] = useState<LoginEvent[]>([]);
	let eventSource: EventSource;

	useEffect(() => {
		if (!listening) {
			eventSource = new EventSource("http://localhost:8080/events/login");

			eventSource.onopen = (event) => {
				console.log("connection opened")
			}

			eventSource.onmessage = (event) => {
				const loginEvents = JSON.parse(event.data);
				console.log("event: ", event.data);
				setData(old => [...old, loginEvents])
			}

			eventSource.onerror = (event: any) => {
				console.log(event.target.readyState)
				if (event.target.readyState === EventSource.CLOSED) {
					console.log('eventsource closed (' + event.target.readyState + ')')
				}
				eventSource.close();
			}

			setListening(true);
		}

		return () => {
			eventSource?.close();
			console.log("eventsource closed")
		}

	}, [])

	return (
			<>
				Login Events
				{data.map((loginEvent, i) =>
						<>
						<p key={i}>ip: {loginEvent.ip}, port: {loginEvent.port}, username: {loginEvent.user} password: {loginEvent.password}</p>
						</>
				)}

			</>
	);
};
