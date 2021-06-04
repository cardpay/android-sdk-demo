//[sdk-ui](../../../index.md)/[com.unlimint.sdk.ui.api.model.info](../index.md)/[Customer](index.md)/[phone](phone.md)



# phone  
[androidJvm]  
Content  
val [phone](phone.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null  
More info  


Customer’s phone number Recommended to send phone number in following format "+1 111111111" with country code and subscriber sections (only digits are accepted) of the number, "+" as prefix and "space" as delimiter. Refer to ITU-E.164 for additional information on format and length. Mandatory for wallets where setting in PM "May omit customer_layout email" is enabled and customer_layout.email isn't presented in request

  



