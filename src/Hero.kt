
abstract class Hero(health: Int, damage: Int, name: String, val ability: SuperAbility) : GameEntity(health, damage, name), HavingSuperAbility {


    open fun attack(boss: Boss) {
        boss.health -= this.damage
    }

    override fun toString(): String {
        return "${super.toString()} ability: $ability"
    }
}