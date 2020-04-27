package di.playground.core.data

interface Settings {
    fun log() = this.javaClass.simpleName
}

class VolumeSettings : Settings
class UserSettings : Settings
class ThemeSettings : Settings
class PrivacySettings : Settings