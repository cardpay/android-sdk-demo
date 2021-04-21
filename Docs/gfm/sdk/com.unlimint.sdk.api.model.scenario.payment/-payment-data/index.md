//[sdk](../../../index.md)/[com.unlimint.sdk.api.model.scenario.payment](../index.md)/[PaymentData](index.md)



# PaymentData  
 [androidJvm] data class [PaymentData](index.md)(**amount**: [Amount](../-amount/index.md), **dynamicDescriptor**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, **note**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, **transType**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, **items**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Item](../-item/index.md)>?, **shippingAddress**: [ShippingAddress](../-shipping-address/index.md)?) : [Serializable](https://developer.android.com/reference/kotlin/java/io/Serializable.html)   


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="com.unlimint.sdk.api.model.scenario.payment/PaymentData/amount/#/PointingToDeclaration/"></a>[amount](amount.md)| <a name="com.unlimint.sdk.api.model.scenario.payment/PaymentData/amount/#/PointingToDeclaration/"></a> [androidJvm] val [amount](amount.md): [Amount](../-amount/index.md)The total transaction amount in selected currency with dot as a decimal separator, must be less than 100 millions   <br>|
| <a name="com.unlimint.sdk.api.model.scenario.payment/PaymentData/dynamicDescriptor/#/PointingToDeclaration/"></a>[dynamicDescriptor](dynamic-descriptor.md)| <a name="com.unlimint.sdk.api.model.scenario.payment/PaymentData/dynamicDescriptor/#/PointingToDeclaration/"></a> [androidJvm] val [dynamicDescriptor](dynamic-descriptor.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = nullShort description of the service or product, must be enabled by CardPay manager to be used.   <br>|
| <a name="com.unlimint.sdk.api.model.scenario.payment/PaymentData/items/#/PointingToDeclaration/"></a>[items](items.md)| <a name="com.unlimint.sdk.api.model.scenario.payment/PaymentData/items/#/PointingToDeclaration/"></a> [androidJvm] val [items](items.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Item](../-item/index.md)>? = nullArray of items (in the shopping cart)   <br>|
| <a name="com.unlimint.sdk.api.model.scenario.payment/PaymentData/note/#/PointingToDeclaration/"></a>[note](note.md)| <a name="com.unlimint.sdk.api.model.scenario.payment/PaymentData/note/#/PointingToDeclaration/"></a> [androidJvm] val [note](note.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = nullNote about the transaction that will not be displayed to customer_layout   <br>|
| <a name="com.unlimint.sdk.api.model.scenario.payment/PaymentData/shippingAddress/#/PointingToDeclaration/"></a>[shippingAddress](shipping-address.md)| <a name="com.unlimint.sdk.api.model.scenario.payment/PaymentData/shippingAddress/#/PointingToDeclaration/"></a> [androidJvm] val [shippingAddress](shipping-address.md): [ShippingAddress](../-shipping-address/index.md)? = nullShipping Address   <br>|
| <a name="com.unlimint.sdk.api.model.scenario.payment/PaymentData/transType/#/PointingToDeclaration/"></a>[transType](trans-type.md)| <a name="com.unlimint.sdk.api.model.scenario.payment/PaymentData/transType/#/PointingToDeclaration/"></a> [androidJvm] val [transType](trans-type.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = nullIdentifies the type of transaction being authenticated.   <br>|

