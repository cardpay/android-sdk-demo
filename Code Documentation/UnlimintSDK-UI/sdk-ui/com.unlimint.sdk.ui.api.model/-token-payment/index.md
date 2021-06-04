//[sdk-ui](../../../index.md)/[com.unlimint.sdk.ui.api.model](../index.md)/[TokenPayment](index.md)



# TokenPayment  
 [androidJvm] object [TokenPayment](index.md)   


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="com.unlimint.sdk.ui.api.model/TokenPayment.CardAccount///PointingToDeclaration/"></a>[CardAccount](-card-account/index.md)| <a name="com.unlimint.sdk.ui.api.model/TokenPayment.CardAccount///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>data class [CardAccount](-card-account/index.md)(**tokenData**: [TokenPayment.TokenData](-token-data/index.md), **billingAddress**: [BillingAddress](../../com.unlimint.sdk.ui.api.model.info/-billing-address/index.md)?) : [Serializable](https://developer.android.com/reference/kotlin/java/io/Serializable.html)  <br><br><br>|
| <a name="com.unlimint.sdk.ui.api.model/TokenPayment.Data///PointingToDeclaration/"></a>[Data](-data/index.md)| <a name="com.unlimint.sdk.ui.api.model/TokenPayment.Data///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>data class [Data](-data/index.md)(**merchantName**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **customer**: [Customer](../../com.unlimint.sdk.ui.api.model.info/-customer/index.md), **merchantOrder**: [MerchantOrder](../../com.unlimint.sdk.ui.api.model.info/-merchant-order/index.md), **paymentData**: [PaymentData](../../com.unlimint.sdk.ui.api.model.payment/-payment-data/index.md), **cardAccount**: [TokenPayment.CardAccount](-card-account/index.md))  <br><br><br>|
| <a name="com.unlimint.sdk.ui.api.model/TokenPayment.TokenData///PointingToDeclaration/"></a>[TokenData](-token-data/index.md)| <a name="com.unlimint.sdk.ui.api.model/TokenPayment.TokenData///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>data class [TokenData](-token-data/index.md)(**token**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **last4PanDigits**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [Serializable](https://developer.android.com/reference/kotlin/java/io/Serializable.html)  <br><br><br>|

