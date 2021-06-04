//[sdk](../../../index.md)/[com.unlimint.sdk.api.model.scenario.binding](../index.md)/[BindingResult](index.md)



# BindingResult  
 [androidJvm] sealed class [BindingResult](index.md)

Result of bank card binding

   


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="com.unlimint.sdk.api.model.scenario.binding/BindingResult.Error///PointingToDeclaration/"></a>[Error](-error/index.md)| <a name="com.unlimint.sdk.api.model.scenario.binding/BindingResult.Error///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>data class [Error](-error/index.md)(**error**: [UnlimintSdkException](../../com.unlimint.sdk.api.exceptions/-unlimint-sdk-exception/index.md)) : [BindingResult](index.md)  <br>More info  <br>Error result of binding  <br><br><br>|
| <a name="com.unlimint.sdk.api.model.scenario.binding/BindingResult.Success///PointingToDeclaration/"></a>[Success](-success/index.md)| <a name="com.unlimint.sdk.api.model.scenario.binding/BindingResult.Success///PointingToDeclaration/"></a>[androidJvm]  <br>Content  <br>data class [Success](-success/index.md)(**panLast4Digits**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **redirectUrl**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, **recurringId**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [BindingResult](index.md)  <br>More info  <br>Success result of binding.  <br><br><br>|


## Inheritors  
  
|  Name | 
|---|
| <a name="com.unlimint.sdk.api.model.scenario.binding/BindingResult.Success///PointingToDeclaration/"></a>[BindingResult](-success/index.md)|
| <a name="com.unlimint.sdk.api.model.scenario.binding/BindingResult.Error///PointingToDeclaration/"></a>[BindingResult](-error/index.md)|

