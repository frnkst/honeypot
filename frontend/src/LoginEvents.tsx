import {LoginEvent} from "./Dashboard";

type LoginEventsProps = {
	events: LoginEvent[]
}

export const ABC = function ({
															 events,

														 }: LoginEventsProps) {

	console.log("fank", events)
	return <>
    { events.map((ev) => <p>{ev.ip} and {ev.user} with {ev.password}</p>)}
	</>
}
