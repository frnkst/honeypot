import React from 'react'
import {LoginEvents} from "./components/LoginEvents";

export const Dashboard = () => {
	return (
			<div style={{ "marginTop": "20px", "textAlign": "center" }}>
				<h1>Dashboard</h1>
					<LoginEvents/>
			</div>
	)
}
