package com.example.naverloginkotlinsdk

import ThirdPartyLogin.NaverThirdPartyLoginConnection

actual class NaverLogin(
	private val sdk: NaverThirdPartyLoginConnection = requireNotNull(NaverThirdPartyLoginConnection.getSharedInstance())
) {
	actual fun getAccessToken() = sdk.accessToken()
	actual fun getRefreshToken() = sdk.refreshToken()
	//	actual fun getExpiresAt() = sdk.accessTokenExpireDate()
	actual fun getTokenType() = sdk.tokenType()
	actual fun getState() = sdk.state().toInt()
}