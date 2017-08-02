




查看签名信息

keytool -list -keystore  C:\Users\Sasa\Desktop\work\key\android.keystore -v




debug.keystore的相关信息
Keystore name: “debug.keystore”

Keystore password: “android”

Key alias: “androiddebugkey”

Key password: “android”

CN: “CN=Android Debug,O=Android,C=US”




①修改android.keystore的别名
keytool -changealias -keystore android.keystore -alias android -destalias androiddebugkey


②修改android.keystore的别名密码
keytool -keypasswd -keystore android.keystore -alias androiddebugkey
③修改android.keystore的密码
keytool -storepasswd -keystore android.keystore