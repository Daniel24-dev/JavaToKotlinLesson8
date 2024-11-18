
class Boss(health: Int, damage: Int, name: String) : GameEntity(health, damage, name) {
     var defence: SuperAbility = SuperAbility.HEAL

    fun chooseDefence() {
        val variants = SuperAbility.values()
        val randomIndex = RPG_Game.random.nextInt(variants.size)
        this.defence = variants[randomIndex]
    }

    fun attack(heroes: Array<Hero>) {
        for (hero in heroes) {
            if (hero.health > 0) {
                if (hero is Berserk && this.defence != SuperAbility.BLOCK_DAMAGE_REVERT) {
                    val blocked = (RPG_Game.random.nextInt(2) + 1) * 5
                    hero.setBlockedDamage(blocked)
                    hero.health -= (this.damage - blocked)
                } else {
                    hero.health -= this.damage
                }
            }
        }
    }

    override fun toString(): String {
        return "BOSS ${super.toString()} defence: $defence"
    }
}