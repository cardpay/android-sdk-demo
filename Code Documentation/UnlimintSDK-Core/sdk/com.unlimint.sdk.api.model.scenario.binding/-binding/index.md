//[sdk](../../../index.md)/[com.unlimint.sdk.api.model.scenario.binding](../index.md)/[Binding](index.md)



# Binding  
 [androidJvm] data class [Binding](index.md)(**currency**: [Currency](https://developer.android.com/reference/kotlin/java/util/Currency.html), **customer**: [Customer](../../com.unlimint.sdk.api.model/-customer/index.md), **merchantOrder**: [MerchantOrder](../../com.unlimint.sdk.api.model/-merchant-order/index.md)?, **cardAccount**: [Binding.CardAccount](-card-account/index.md)?)   


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="com.unlimint.sdk.api.model.scenario.binding/Binding.CardAccount///PointingToDeclaration/"></a>[CardAccount](-card-account/index.md)| <a name="com.unlimint.sdk.api.model.scenario.binding/Binding.CardAccount///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>data class [CardAccount](-card-account/index.md)(**billingAddress**: [BillingAddress](../../com.unlimint.sdk.api.model/-billing-address/index.md)?) : [Serializable](https://developer.android.com/reference/kotlin/java/io/Serializable.html)  <br><br><br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="com.unlimint.sdk.api.model.scenario.binding/Binding/cardAccount/#/PointingToDeclaration/"></a>[cardAccount](card-account.md)| <a name="com.unlimint.sdk.api.model.scenario.binding/Binding/cardAccount/#/PointingToDeclaration/"></a> [androidJvm] val [cardAccount](card-account.md): [Binding.CardAccount](-card-account/index.md)? = nullCard account data   <br>|
| <a name="com.unlimint.sdk.api.model.scenario.binding/Binding/currency/#/PointingToDeclaration/"></a>[currency](currency.md)| <a name="com.unlimint.sdk.api.model.scenario.binding/Binding/currency/#/PointingToDeclaration/"></a> [androidJvm] val [currency](currency.md): [Currency](https://developer.android.com/reference/kotlin/java/util/Currency.html)the currency for the lowest payment from card for binding   <br>|
| <a name="com.unlimint.sdk.api.model.scenario.binding/Binding/customer/#/PointingToDeclaration/"></a>[customer](customer.md)| <a name="com.unlimint.sdk.api.model.scenario.binding/Binding/customer/#/PointingToDeclaration/"></a> [androidJvm] val [customer](customer.md): [Customer](../../com.unlimint.sdk.api.model/-customer/index.md)Customer data   <br>|
| <a name="com.unlimint.sdk.api.model.scenario.binding/Binding/merchantOrder/#/PointingToDeclaration/"></a>[merchantOrder](merchant-order.md)| <a name="com.unlimint.sdk.api.model.scenario.binding/Binding/merchantOrder/#/PointingToDeclaration/"></a> [androidJvm] val [merchantOrder](merchant-order.md): [MerchantOrder](../../com.unlimint.sdk.api.model/-merchant-order/index.md)? = nullMerchant order data   <br>|

