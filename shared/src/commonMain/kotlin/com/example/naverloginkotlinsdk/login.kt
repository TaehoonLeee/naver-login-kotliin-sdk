package com.example.naverloginkotlinsdk

expect class NaverLogin {
	fun getAccessToken(): String?
	fun getRefreshToken(): String?
	//	fun getExpiresAt(): Long
	fun getTokenType(): String?
	fun getState(): Int
}