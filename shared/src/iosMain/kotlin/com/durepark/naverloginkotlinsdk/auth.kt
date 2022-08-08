package com.durepark.naverloginkotlinsdk

import kotlin.naver.login.NaverThirdPartyLoginConnection
import kotlin.naver.login.NaverThirdPartyLoginConnectionDelegateProtocol
import platform.UIKit.UIView

actual typealias ApplicationContext = UIView
actual typealias AuthCallback = NaverThirdPartyLoginConnectionDelegateProtocol

actual class NaverAuth(
	private val sdk: NaverThirdPartyLoginConnection = requireNotNull(NaverThirdPartyLoginConnection.getSharedInstance())
) {
	actual fun initialize(context: UIView, id: String, secret: String, name: String) = with(sdk) {
		setIsNaverAppOauthEnable(true)
		setIsInAppOauthEnable(true)
		setConsumerSecret(secret)
		setConsumerKey(id)
		setAppName(name)
	}

	actual fun authenticate(authCallback: AuthCallback) {
		sdk.delegate = authCallback
		sdk.requestThirdPartyLogin()
	}
}