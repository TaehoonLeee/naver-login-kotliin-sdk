package com.durepark.naverloginkotlinsdk

expect class ApplicationContext
expect interface AuthCallback

expect class NaverAuth {
	fun initialize(context: ApplicationContext, id: String, secret: String, name: String)
	fun authenticate(authCallback: AuthCallback)
}