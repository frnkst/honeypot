import WeatherInfoEvent.LoginAttemptEvent

interface LoginAttemptEventListener {
    fun onData(event: LoginAttemptEvent?)
    fun processComplete()
}
