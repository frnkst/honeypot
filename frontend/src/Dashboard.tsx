import React, {useState} from 'react'
import {SSEProvider, useSSE} from "react-hooks-sse";

export type LoginEvent = {
	ip: string
	user: string
	password: string
}


const loginEvents: LoginEvent[] = [];

const Comments = () => {
	const state = useSSE<LoginEvent>('message', { ip: '', user: '', password: ''});
	loginEvents.push(state)

	return <>
		{ loginEvents.map((event) => <><p>{ event.ip } { event.user } { event.password }</p></>) }
		</>
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
