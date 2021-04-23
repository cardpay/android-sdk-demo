//[sdk](../../../index.md)/[com.unlimint.sdk.api](../index.md)/[MobileSdkInterface](index.md)/[paymentWithPayPalForResult](payment-with-pay-pal-for-result.md)



# paymentWithPayPalForResult  
[androidJvm]  
Content  
abstract fun [paymentWithPayPalForResult](payment-with-pay-pal-for-result.md)(activity: [AppCompatActivity](https://developer.android.com/reference/kotlin/androidx/appcompat/app/AppCompatActivity.html), mobileAuthorizationToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), paymentMethodData: [Payment.PayPalData](../../com.unlimint.sdk.api.model.scenario.payment/-payment/-pay-pal-data/index.md), environment: , requestCode: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))  
More info  


Make a payment with PayPal



*Mandatory params*



#### Return  


You have to catch the answer from onActivityResult with your *requestCode* if resultCode == Activity.RESULT_OK then get result data from Intent with MobileSdk.ARG_LAST_4_DIGITS flag if user's decided save the card for next payment or empty Intent if resultCode == Activity.RESULT_CANCEL then you may get *Exception* from Intent with MobileSdk.EXCEPTION flag data: Intent. If data is empty, then the user just closed the SDK



Variety of errors at onActivityResult()



## Parameters  
  
androidJvm  
  
| | |
|---|---|
| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentWithPayPalForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.PayPalData#Environments#kotlin.Int/PointingToDeclaration/"></a>activity| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentWithPayPalForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.PayPalData#Environments#kotlin.Int/PointingToDeclaration/"></a><br><br>for calling our Activity<br><br>|
| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentWithPayPalForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.PayPalData#Environments#kotlin.Int/PointingToDeclaration/"></a>mobileAuthorizationToken| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentWithPayPalForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.PayPalData#Environments#kotlin.Int/PointingToDeclaration/"></a><br><br>Mobile token received from Unlimint (authentication mobile token)<br><br>|
| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentWithPayPalForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.PayPalData#Environments#kotlin.Int/PointingToDeclaration/"></a>paymentMethodData| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentWithPayPalForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.PayPalData#Environments#kotlin.Int/PointingToDeclaration/"></a><br><br>needed information for payment<br><br>|
| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentWithPayPalForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.PayPalData#Environments#kotlin.Int/PointingToDeclaration/"></a>requestCode| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentWithPayPalForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.PayPalData#Environments#kotlin.Int/PointingToDeclaration/"></a><br><br>code for startActivityForResult<br><br>|
  


#### Throws  
  
| | |
|---|---|
| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentWithPayPalForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.PayPalData#Environments#kotlin.Int/PointingToDeclaration/"></a>[com.unlimint.sdk.api.exceptions.MobileSdkServiceUnavailableException](../../com.unlimint.sdk.api.exceptions/-mobile-sdk-service-unavailable-exception/index.md)| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentWithPayPalForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.PayPalData#Environments#kotlin.Int/PointingToDeclaration/"></a><br><br>some io errors<br><br>|
| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentWithPayPalForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.PayPalData#Environments#kotlin.Int/PointingToDeclaration/"></a>[com.unlimint.sdk.api.exceptions.MobileSdkUnauthorizedException](../../com.unlimint.sdk.api.exceptions/-mobile-sdk-unauthorized-exception/index.md)| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentWithPayPalForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.PayPalData#Environments#kotlin.Int/PointingToDeclaration/"></a><br><br>try to refresh your *mobileToken*<br><br>|
| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentWithPayPalForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.PayPalData#Environments#kotlin.Int/PointingToDeclaration/"></a>[com.unlimint.sdk.api.exceptions.MobileSdkIllegalStateException](../../com.unlimint.sdk.api.exceptions/-mobile-sdk-illegal-state-exception/index.md)| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentWithPayPalForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.PayPalData#Environments#kotlin.Int/PointingToDeclaration/"></a><br><br>some business errors, look at the message<br><br>|
| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentWithPayPalForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.PayPalData#Environments#kotlin.Int/PointingToDeclaration/"></a>[com.unlimint.sdk.api.exceptions.MobileSdkPaymentDeclineException](../../com.unlimint.sdk.api.exceptions/-mobile-sdk-payment-decline-exception/index.md)| <a name="com.unlimint.sdk.api/MobileSdkInterface/paymentWithPayPalForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.api.model.scenario.payment.Payment.PayPalData#Environments#kotlin.Int/PointingToDeclaration/"></a><br><br>Payment was rejected<br><br><br><br>After filling bank card requisites, you have to get TRANSACTION_ID from LocalBroadcast with Intent(MobileSdk.TransactionData.TRANSACTION_ACTION). Get the data from received Intent with name MobileSdk.TransactionData.TRANSACTION_ID Then send it to your server for checking.<br><br>|
  



