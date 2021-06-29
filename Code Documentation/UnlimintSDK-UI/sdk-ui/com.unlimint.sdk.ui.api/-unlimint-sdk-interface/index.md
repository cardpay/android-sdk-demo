//[sdk-ui](../../../index.md)/[com.unlimint.sdk.ui.api](../index.md)/[UnlimintSdkInterface](index.md)



# UnlimintSdkInterface  
 [androidJvm] interface [UnlimintSdkInterface](index.md)   


## Functions  
  
|  Name |  Summary | 
|---|---|
| <a name="com.unlimint.sdk.ui.api/UnlimintSdkInterface/bindNewCardForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.ui.api.model.Binding.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a>[bindNewCardForResult](bind-new-card-for-result.md)| <a name="com.unlimint.sdk.ui.api/UnlimintSdkInterface/bindNewCardForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.ui.api.model.Binding.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>abstract fun [bindNewCardForResult](bind-new-card-for-result.md)(activity: [AppCompatActivity](https://developer.android.com/reference/kotlin/androidx/appcompat/app/AppCompatActivity.html), mobileAuthorizationToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), bindingMethodData: [Binding.Data](../../com.unlimint.sdk.ui.api.model/-binding/-data/index.md), environment: , launcher: [ActivityResultLauncher](https://developer.android.com/reference/kotlin/androidx/activity/result/ActivityResultLauncher.html)<[Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html)>)  <br>More info  <br>Binds bank card.  <br><br><br>|
| <a name="com.unlimint.sdk.ui.api/UnlimintSdkInterface/close/#android.content.Context/PointingToDeclaration/"></a>[close](close.md)| <a name="com.unlimint.sdk.ui.api/UnlimintSdkInterface/close/#android.content.Context/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>abstract fun [close](close.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html))  <br>More info  <br>Close our SDK Activity  <br><br><br>|
| <a name="com.unlimint.sdk.ui.api/UnlimintSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.ui.api.model.Payment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a>[paymentForResult](payment-for-result.md)| <a name="com.unlimint.sdk.ui.api/UnlimintSdkInterface/paymentForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.ui.api.model.Payment.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>abstract fun [paymentForResult](payment-for-result.md)(activity: [AppCompatActivity](https://developer.android.com/reference/kotlin/androidx/appcompat/app/AppCompatActivity.html), mobileAuthorizationToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), paymentMethodData: [Payment.Data](../../com.unlimint.sdk.ui.api.model/-payment/-data/index.md), environment: , launcher: [ActivityResultLauncher](https://developer.android.com/reference/kotlin/androidx/activity/result/ActivityResultLauncher.html)<[Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html)>)  <br>More info  <br>Make a payment*Mandatory params*  <br><br><br>[androidJvm]  <br>Content  <br>abstract fun [paymentForResult](payment-for-result.md)(activity: [AppCompatActivity](https://developer.android.com/reference/kotlin/androidx/appcompat/app/AppCompatActivity.html), mobileAuthorizationToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), tokenPaymentMethodData: [TokenPayment.Data](../../com.unlimint.sdk.ui.api.model/-token-payment/-data/index.md), environment: , launcher: [ActivityResultLauncher](https://developer.android.com/reference/kotlin/androidx/activity/result/ActivityResultLauncher.html)<[Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html)>)  <br>More info  <br>Make a payment with the token of the saved card*Mandatory params*  <br><br><br>|
| <a name="com.unlimint.sdk.ui.api/UnlimintSdkInterface/paymentWithPayPalForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.ui.api.model.Payment.PayPalData#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a>[paymentWithPayPalForResult](payment-with-pay-pal-for-result.md)| <a name="com.unlimint.sdk.ui.api/UnlimintSdkInterface/paymentWithPayPalForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.ui.api.model.Payment.PayPalData#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>abstract fun [paymentWithPayPalForResult](payment-with-pay-pal-for-result.md)(activity: [AppCompatActivity](https://developer.android.com/reference/kotlin/androidx/appcompat/app/AppCompatActivity.html), mobileAuthorizationToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), paymentMethodData: [Payment.PayPalData](../../com.unlimint.sdk.ui.api.model/-payment/-pay-pal-data/index.md), environment: , launcher: [ActivityResultLauncher](https://developer.android.com/reference/kotlin/androidx/activity/result/ActivityResultLauncher.html)<[Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html)>)  <br>More info  <br>Make a payment with PayPal*Mandatory params*  <br><br><br>|


## Inheritors  
  
|  Name | 
|---|
| <a name="com.unlimint.sdk.ui.api/UnlimintSdk///PointingToDeclaration/"></a>[UnlimintSdk](../-unlimint-sdk/index.md)|
