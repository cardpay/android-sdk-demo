//[sdk](../../../index.md)/[com.unlimint.sdk.api.model.scenario.payment.paypal](../index.md)/[PaymentPayPalResult](index.md)



# PaymentPayPalResult  
 [androidJvm] sealed class [PaymentPayPalResult](index.md)

Result of payment by PayPal

   


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="com.unlimint.sdk.api.model.scenario.payment.paypal/PaymentPayPalResult.Error///PointingToDeclaration/"></a>[Error](-error/index.md)| <a name="com.unlimint.sdk.api.model.scenario.payment.paypal/PaymentPayPalResult.Error///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>data class [Error](-error/index.md)(**error**: [UnlimintSdkException](../../com.unlimint.sdk.api.exceptions/-unlimint-sdk-exception/index.md)) : [PaymentPayPalResult](index.md)  <br>More info  <br>Error result of payment  <br><br><br>|
| <a name="com.unlimint.sdk.api.model.scenario.payment.paypal/PaymentPayPalResult.Success///PointingToDeclaration/"></a>[Success](-success/index.md)| <a name="com.unlimint.sdk.api.model.scenario.payment.paypal/PaymentPayPalResult.Success///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>data class [Success](-success/index.md)(**redirectUrl**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, **transactionId**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [PaymentPayPalResult](index.md)  <br>More info  <br>Success result of payment  <br><br><br>|


## Inheritors  
  
|  Name | 
|---|
| <a name="com.unlimint.sdk.api.model.scenario.payment.paypal/PaymentPayPalResult.Success///PointingToDeclaration/"></a>[PaymentPayPalResult](-success/index.md)|
| <a name="com.unlimint.sdk.api.model.scenario.payment.paypal/PaymentPayPalResult.Error///PointingToDeclaration/"></a>[PaymentPayPalResult](-error/index.md)|

