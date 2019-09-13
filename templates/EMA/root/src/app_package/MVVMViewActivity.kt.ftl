package ${packageName}
<#if !parentActivity?has_content>
import es.babel.easymvvm.android.ui.EmaToolbarFragmentActivity
</#if>
import org.kodein.di.Kodein

class ${functionalityName}ViewActivity : <#if parentActivity?has_content>${parentActivity}<#else>EmaToolbarFragmentActivity</#if>() {

	override fun injectActivityModule(kodein: Kodein.MainBuilder): Kodein.Module? = null

    override fun getNavGraph(): Int = R.navigation.navigationGraphID

    override fun getToolbarTitle(): String? = null

    override fun getLayout(): Int = R.layout.activityID

}