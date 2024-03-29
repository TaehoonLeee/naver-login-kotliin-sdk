package com.durepark.naverloginkotlinsdk

import android.app.Application
import com.navercorp.nid.NaverIdLoginSDK
import com.navercorp.nid.oauth.OAuthLoginCallback

actual typealias ApplicationContext = Application
actual interface AuthCallback : OAuthLoginCallback

actual class NaverAuth(
	private val sdk: NaverIdLoginSDK = NaverIdLoginSDK
) {
	actual fun initialize(context: Application, id: String, secret: String, name: String)  {
		sdk.applicationContext = context
		sdk.initialize(context, id, secret, name)
	}

	actual fun authenticate(authCallback: AuthCallback) = sdk.authenticate(NaverIdLoginSDK.applicationContext, authCallback)
}