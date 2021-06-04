//[sdk-ui](../../../index.md)/[com.unlimint.sdk.ui.api.model.info](../index.md)/[Customer](index.md)



# Customer  
 [androidJvm] data class [Customer](index.md)(**id**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **email**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **ip**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, **locale**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, **phone**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, **homePhone**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, **workPhone**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) : [Serializable](https://developer.android.com/reference/kotlin/java/io/Serializable.html)   


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="com.unlimint.sdk.ui.api.model.info/Customer/email/#/PointingToDeclaration/"></a>[email](email.md)| <a name="com.unlimint.sdk.ui.api.model.info/Customer/email/#/PointingToDeclaration/"></a> [androidJvm] val [email](email.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)Customer’s e-mail address Optional for wallets where setting in PM "May omit customer_layout email" is enabled   <br>|
| <a name="com.unlimint.sdk.ui.api.model.info/Customer/homePhone/#/PointingToDeclaration/"></a>[homePhone](home-phone.md)| <a name="com.unlimint.sdk.ui.api.model.info/Customer/homePhone/#/PointingToDeclaration/"></a> [androidJvm] val [homePhone](home-phone.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = nullThe home phone number provided by the Cardholder.   <br>|
| <a name="com.unlimint.sdk.ui.api.model.info/Customer/id/#/PointingToDeclaration/"></a>[id](id.md)| <a name="com.unlimint.sdk.ui.api.model.info/Customer/id/#/PointingToDeclaration/"></a> [androidJvm] val [id](id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)Customer ID is a unique identifier of a cardholder at the Recurring payments service.   <br>|
| <a name="com.unlimint.sdk.ui.api.model.info/Customer/ip/#/PointingToDeclaration/"></a>[ip](ip.md)| <a name="com.unlimint.sdk.ui.api.model.info/Customer/ip/#/PointingToDeclaration/"></a> [androidJvm] val [ip](ip.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = nullCustomer’s IPv4 Mandatory only for S2S mode   <br>|
| <a name="com.unlimint.sdk.ui.api.model.info/Customer/locale/#/PointingToDeclaration/"></a>[locale](locale.md)| <a name="com.unlimint.sdk.ui.api.model.info/Customer/locale/#/PointingToDeclaration/"></a> [androidJvm] val [locale](locale.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = nullPreferred locale for the payment page (ISO 639-1 language code).   <br>|
| <a name="com.unlimint.sdk.ui.api.model.info/Customer/phone/#/PointingToDeclaration/"></a>[phone](phone.md)| <a name="com.unlimint.sdk.ui.api.model.info/Customer/phone/#/PointingToDeclaration/"></a> [androidJvm] val [phone](phone.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = nullCustomer’s phone number Recommended to send phone number in following format "+1 111111111" with country code and subscriber sections (only digits are accepted) of the number, "+" as prefix and "space" as delimiter.   <br>|
| <a name="com.unlimint.sdk.ui.api.model.info/Customer/workPhone/#/PointingToDeclaration/"></a>[workPhone](work-phone.md)| <a name="com.unlimint.sdk.ui.api.model.info/Customer/workPhone/#/PointingToDeclaration/"></a> [androidJvm] val [workPhone](work-phone.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = nullThe work phone number provided by the Cardholder.   <br>|

