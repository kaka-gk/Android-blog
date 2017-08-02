

Android 重签名
-------------------




####
[参考链接地址]: http://www.cnblogs.com/findyou/p/3801273.html



#### 原理

* APK签名的要点
 
 a.所有的应用程序都必须有数字证书 ，Android系统不会安装一个没有数字证书的应用程序；

 b.Android程序包使用的数字证书可以是自签名的，不需要一个权威的数字证书机构签名认证；

 c.数字证书都是存在有效期的，Android只是在应用程序安装的时候才会检查证书的有效期。如果程序已经安装在系统中，即使证书过期也不会影响程序的正常功能。 

 d.Android使用标准的java工具 Keytool 、Jarsigner 来生成数字证书，并给应用程序包签名。


* APK签名的好处 

 a、应用程序升级：如果想升级应用程序，签名证书要相同，包名称要相同！
 b、应用程序模块化：Android 系统可以允许同一个证书签名的多个应用程序在一个进程里运行，系统实际把他们作为一个单个的应用程序，此时就可以把我们的应用程序以模块的方式进行部署，而用户可以独立的升级其中的一个模块。

 c、代码或者数据共享：Android 提供了基于签名的权限机制，那么一个应用程序就可以为另一个以相同证书签名的应用程序公开自己的功能。以同一个证书对多个应用程序进行签名，利用基于签名的权限检查，你就可以在应用程序间以安全的方式共享代码和数据了。
 

* APK重签名原理
 
 a、Android系统签名主要有ROM签名和应用程序APK签名两种形式。ROM签名是针对已经生成的Android系统ROM包进行签名。应用程序APK签名是针对开发者开发的应用程序APK进行签名。

 b、APK实际上是一个jar或者说是一个zip压缩文件，META-INF目录下存放的是压缩包中所有文件的签名信息，用来保证apk包的完整性和系统的安全。

 c、重签名：实际上就是删除META-INF目录(删除已有签名)，使用自已数据证书再次重签名。



#### 生成数字证书

keytool -genkey -v -keystore debug.keystore -alias androiddebugkey -keyalg RSA -validity 10000
 /*解释： 
keytool是工具名称，-genkey意味着执行的是生成数字证书操作，-v表示将生成证书的详细信息打印出来，显示在dos窗口中； 
-keystore  debug.keystore 表示生成的数字证书的文件名为“ debug.keystore”；
-alias  androiddebugkey   表示证书的别名为“ androiddebugkey  ”，可以与Keystore一样；
-keyalg RSA 表示生成密钥文件所采用的算法为RSA；
-validity 10000 表示该数字证书的有效期为10000天，意味着10000天之后该证书将失效
**/  


#### 重签名

jarsigner -verbose -keystore debug.keystore -storepass android -keypass android -signedjar Thinkdrive_signed.apk  Thinkdrive_temp.apk androiddebugkey


/*解释： jarsigner是Java的签名工具

-verbose参数表示：显示出签名详细信息

-keystore表示使用当前目录中的debug.keystore签名证书文件。

-storepass 密钥口令 

-signedjar ThinkDrive_signed.apk表示签名后生成的APK名称，

ThinkDrive_temp.apk 表示未签名的APK，

androiddebugkey表示debug.keystore的别名




jarsigner  -verbose -keystore /Users/longer/Desktop/work/project-space/fm820/keystore/fm820.keystore -signedjar /Users/longer/Desktop/fm820_c360_2.1.1.encrypted_s.apk /Users/longer/Desktop/fm820_c360_2.1.1.encrypted.apk android