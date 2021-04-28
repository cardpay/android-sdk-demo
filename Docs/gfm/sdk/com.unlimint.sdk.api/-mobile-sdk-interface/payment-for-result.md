//[sdk](../../../index.md)/[com.unlimint.sdk.api](../index.md)/[MobileSdkInterface](index.md)/[paymentForResult](payment-for-result.md)



# paymentForResult  
[androidJvm]  
Content  
abstract fun [paymentForResult](payment-for-result.md)(activity: [AppCompatActivity](https://developer.android.com/reference/kotlin/androidx/appcompat/app/AppCompatActivity.html), mobileAuthorizationToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), paymentMethodData: [Payment.Data](../../com.unlimint.sdk.api.model.scenario.payment/-payment/-data/index.md), environment: , launcher: [ActivityResultLauncher](https://developer.android.com/reference/kotlin/androidx/activity/result/ActivityResultLauncher.html)<[Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html)>)  
More info  


Make a payment



*Mandatory params*



#### Return  


You have to catch the answer from onActivityResult with your *requestCode* if resultCode == Activity.RESULT_OK then get result data from Intent with MobileSdk.ARG_LAST_4_DIGITS flag if user's decided save the card for next payment or empty Intent if resultCode == Activity.RESULT_CANCEL then you may get *Exception* from Intent with MobileSdk.EXCEPTION flag data: Intent. If data is empty, then the user just closed the SDK



Variety of errors at onActivityResult()



## Parameters  
  
androidJvm  
  
| | |
|---|---|
| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a>activity| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a><br><br>for calling our Activity<br><br>|
| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a>mobileAuthorizationToken| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a><br><br>Mobile token received from Unlimint (authentication mobile token)<br><br>|
| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a>paymentMethodData| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a><br><br>needed information for payment<br><br>|
| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a>launcher| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a><br><br>ActivityResultLauncher instance received after registering for activity result<br><br>|
  


#### Throws  
  
| | |
|---|---|
| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a>[com.unlimint.sdk.api.exceptions.MobileSdkServiceUnavailableException](../../com.unlimint.sdk.api.exceptions/-mobile-sdk-service-unavailable-exception/index.md)| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a><br><br>some io errors<br><br>|
| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a>[com.unlimint.sdk.api.exceptions.MobileSdkUnauthorizedException](../../com.unlimint.sdk.api.exceptions/-mobile-sdk-unauthorized-exception/index.md)| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a><br><br>try to refresh your *mobileToken*<br><br>|
| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a>[com.unlimint.sdk.api.exceptions.MobileSdkIllegalStateException](../../com.unlimint.sdk.api.exceptions/-mobile-sdk-illegal-state-exception/index.md)| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a><br><br>some business errors, look at the message<br><br>|
| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a>[com.unlimint.sdk.api.exceptions.MobileSdkPaymentDeclineException](../../com.unlimint.sdk.api.exceptions/-mobile-sdk-payment-decline-exception/index.md)| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a><br><br>Payment was rejected<br><br>|
| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a>[com.unlimint.sdk.api.exceptions.MobileSdkSecurityException](../../com.unlimint.sdk.api.exceptions/-mobile-sdk-security-exception/index.md)| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a><br><br>security error<br><br><br><br>Use LocalBroadcast for catching security error with Intent([MobileSdk.SecurityData.SECURITY_ACTION](../-mobile-sdk/-security-data/-s-e-c-u-r-i-t-y_-a-c-t-i-o-n.md)) and [MobileSdk.SecurityData.SECURITY_EXTRA](../-mobile-sdk/-security-data/-s-e-c-u-r-i-t-y_-e-x-t-r-a.md) key<br><br><br><br>After filling bank card requisites, you have to get TRANSACTION_ID from LocalBroadcast with Intent(MobileSdk.TransactionData.TRANSACTION_ACTION). Get the data from received Intent with name MobileSdk.TransactionData.TRANSACTION_ID Then send it to your server for checking.<br><br>|
  


[androidJvm]  
Content  
abstract fun [paymentForResult](payment-for-result.md)(activity: [AppCompatActivity](https://developer.android.com/reference/kotlin/androidx/appcompat/app/AppCompatActivity.html), mobileAuthorizationToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), tokenPaymentMethodData: [TokenPayment.Data](../../com.unlimint.sdk.api.model.scenario.payment/-token-payment/-data/index.md), environment: , launcher: [ActivityResultLauncher](https://developer.android.com/reference/kotlin/androidx/activity/result/ActivityResultLauncher.html)<[Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html)>)  
More info  


Make a payment with the token of the saved card



*Mandatory params*



#### Return  


You have to catch the answer from onActivityResult with your *requestCode* if resultCode == Activity.RESULT_OK then get result data from empty Intent if resultCode == Activity.RESULT_CANCEL then you may get *Exception* from Intent with MobileSdk.EXCEPTION flag data: Intent. If data is empty, then the user just closed the SDK



Variety of errors at onActivityResult()



## Parameters  
  
androidJvm  
  
| | |
|---|---|
| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.TokenPayment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a>activity| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.TokenPayment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a><br><br>for calling our Activity<br><br>|
| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.TokenPayment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a>mobileAuthorizationToken| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.TokenPayment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a><br><br>Mobile token received from Unlimint (authentication mobile token)<br><br>|
| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.TokenPayment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a>tokenPaymentMethodData| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.TokenPayment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a><br><br>needed information for payment with saved bankcard token<br><br>|
| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.TokenPayment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a>launcher| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.TokenPayment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a><br><br>ActivityResultLauncher instance received after registering for activity result<br><br>|
  


#### Throws  
  
| | |
|---|---|
| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.TokenPayment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a>[com.unlimint.sdk.api.exceptions.MobileSdkServiceUnavailableException](../../com.unlimint.sdk.api.exceptions/-mobile-sdk-service-unavailable-exception/index.md)| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.TokenPayment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a><br><br>some io errors<br><br>|
| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.TokenPayment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a>[com.unlimint.sdk.api.exceptions.MobileSdkUnauthorizedException](../../com.unlimint.sdk.api.exceptions/-mobile-sdk-unauthorized-exception/index.md)| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.TokenPayment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a><br><br>try to refresh your *mobileToken*<br><br>|
| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.TokenPayment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a>[com.unlimint.sdk.api.exceptions.MobileSdkIllegalStateException](../../com.unlimint.sdk.api.exceptions/-mobile-sdk-illegal-state-exception/index.md)| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.TokenPayment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a><br><br>some business errors, look at the message<br><br>|
| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.TokenPayment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a>[com.unlimint.sdk.api.exceptions.MobileSdkPaymentDeclineException](../../com.unlimint.sdk.api.exceptions/-mobile-sdk-payment-decline-exception/index.md)| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.TokenPayment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a><br><br>Payment was rejected<br><br>|
| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.TokenPayment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a>[com.unlimint.sdk.api.exceptions.MobileSdkSecurityException](../../com.unlimint.sdk.api.exceptions/-mobile-sdk-security-exception/index.md)| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.TokenPayment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a><br><br>security error<br><br><br><br>Use LocalBroadcast for catching security error with Intent([MobileSdk.SecurityData.SECURITY_ACTION](../-mobile-sdk/-security-data/-s-e-c-u-r-i-t-y_-a-c-t-i-o-n.md)) and [MobileSdk.SecurityData.SECURITY_EXTRA](../-mobile-sdk/-security-data/-s-e-c-u-r-i-t-y_-e-x-t-r-a.md) key<br><br><br><br>After filling bank card requisites, you have to get TRANSACTION_ID from LocalBroadcast with Intent(MobileSdk.TransactionData.TRANSACTION_ACTION). Get the data from received Intent with name MobileSdk.TransactionData.TRANSACTION_ID Then send it to your server for checking.<br><br>|
  



