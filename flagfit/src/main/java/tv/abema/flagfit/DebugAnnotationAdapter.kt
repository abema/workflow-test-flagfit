package tv.abema.flagfit

import tv.abema.flagfit.annotation.DebugWith
import kotlin.reflect.KClass

class DebugAnnotationAdapter : AnnotationAdapter<DebugWith> {
  override fun canHandle(
    annotation: DebugWith,
    env: Map<String, Any>
  ): Boolean {
    return env[Flagfit.ENV_IS_DEBUG_KEY] == true
  }

  override fun flagType(annotation: DebugWith): KClass<out FlagSource> {
    return annotation.value
  }

  override fun annotationClass(): Class<DebugWith> {
    return DebugWith::class.java
  }
}
