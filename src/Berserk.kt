
class Berserk(health: Int, damage: Int, name: String) : Hero(health, damage, name, SuperAbility.BLOCK_DAMAGE_REVERT) {
    private var blockedDamage: Int = 0

    fun setBlockedDamage(blockedDamage: Int) {
        this.blockedDamage = blockedDamage
    }

    override fun applySuperPower(boss: Boss, heroes: Array<Hero>) {
        boss.health -= blockedDamage
        println("Berserk ${this.name} reverted $blockedDamage damage to the boss.")
    }
}