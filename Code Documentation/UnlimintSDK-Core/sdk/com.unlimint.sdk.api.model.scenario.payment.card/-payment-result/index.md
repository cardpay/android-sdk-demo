//[sdk](../../../index.md)/[com.unlimint.sdk.api.model.scenario.payment.card](../index.md)/[PaymentResult](index.md)



# PaymentResult  
 [androidJvm] sealed class [PaymentResult](index.md)

Result of payment by bank card or bank card token

   


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="com.unlimint.sdk.api.model.scenario.payment.card/PaymentResult.Error///PointingToDeclaration/"></a>[Error](-error/index.md)| <a name="com.unlimint.sdk.api.model.scenario.payment.card/PaymentResult.Error///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>data class [Error](-error/index.md)(**error**: [UnlimintSdkException](../../com.unlimint.sdk.api.exceptions/-unlimint-sdk-exception/index.md)) : [PaymentResult](index.md)  <br>More info  <br>Error result of payment  <br><br><br>|
| <a name="com.unlimint.sdk.api.model.scenario.payment.card/PaymentResult.Success///PointingToDeclaration/"></a>[Success](-success/index.md)| <a name="com.unlimint.sdk.api.model.scenario.payment.card/PaymentResult.Success///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>data class [Success](-success/index.md)(**panLast4Digits**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **redirectUrl**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, **transactionId**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [PaymentResult](index.md)  <br>More info  <br>Success result of payment  <br><br><br>|


## Inheritors  
  
|  Name | 
|---|
| <a name="com.unlimint.sdk.api.model.scenario.payment.card/PaymentResult.Success///PointingToDeclaration/"></a>[PaymentResult](-success/index.md)|
| <a name="com.unlimint.sdk.api.model.scenario.payment.card/PaymentResult.Error///PointingToDeclaration/"></a>[PaymentResult](-error/index.md)|

