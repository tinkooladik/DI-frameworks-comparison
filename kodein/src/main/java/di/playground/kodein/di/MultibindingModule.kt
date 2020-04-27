package di.playground.kodein.di

import di.playground.core.data.*
import org.kodein.di.Kodein
import org.kodein.di.generic.*

/**
 * Multi-binding
 */

typealias SettingsEntry = Pair<String, Settings>
typealias SettingsEntries = Set<SettingsEntry>

val multibindingModule = Kodein.Module("multibinding") {

    /* in set
    * To have multiple bindings in a set, you need to:
        * Declare that you are using a set binding for a particular bound type.
        * Add bindings to the set.
    */
    bind() from setBinding<Settings>()

    bind<Settings>().inSet() with provider { VolumeSettings() }
    bind<Settings>().inSet() with singleton { UserSettings() }


    /* in map
    * Kodein does not directly support map multi-binding.
    * However, it is very easy to create a binding map by using a binding set.
    */

    // First, create the following primitive:
//    typealias SettingsEntry = Pair<String, Settings>
//    typealias SettingsEntries = Set<SettingsEntry>

    // Then, bind with keys:

    bind() from setBinding<SettingsEntry>()

    bind<SettingsEntry>().inSet() with provider { "theme" to ThemeSettings() }
    bind<SettingsEntry>().inSet() with singleton { "privacy" to PrivacySettings() }
}