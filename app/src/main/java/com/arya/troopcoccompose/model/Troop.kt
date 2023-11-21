package com.arya.troopcoccompose.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Troop(
    @PrimaryKey val id: String,
    val name: String?,
    val description: String?,
    val trivia: String?,
    val imgUrl: String?,
    val url: String?,
) : Parcelable

val troops = arrayListOf(
    Troop(
        "1",
        "Super Barbarian",
        "Superior in health, power, speed and most importantly, hair, the Super Barbarians are what regular Barbarians dream of becoming!",
        "You can have a maximum of 64 Super Barbarians at one time in a complete set of fully upgraded Army Camps. This number increases to 74 if you include the 10 that can fit into a fully upgraded Clan Castle. On the battlefield, you can clone an additional 28 Super Barbarians with four fully upgraded Clone Spells (three from the regular spell inventory and one from a max-level Clan Castle), for a total of 102 Super Barbarians.\n\nThe Super Barbarian is called \"Elite Barbarian\" in the game files. However, it is the level 6-7 regular Barbarian, rather than the Super Barbarian, that shares the Iron Helmet with the Clash Royale Elite Barbarians.\n\nSuper Barbarians under their ability have the highest damage per housing space in the game at 68 (Followed by Sneaky Goblins at 63 and 1/3).\n\nIn their artwork, they have a red border on their headpiece but in battle, the border is not there.\n\nThe Super Barbarian's features (long hair, headband, and a shoulder armor) are based on barbarians stereotype.\n\nThe Super Barbarian's ability is similar to that of the Raged Barbarian from the Builder Base.\n\nOn their belt, they have an emblem resembling a standard skull, not a Super Troops skull. This may be because in the Super Giant description, they have a Super Troop logo belt that is from an eating contest, and the Super Barbarians probably did not win one. Additionally, it appears to resemble the \"Miniature\" Super Troop logo from the early stages of the Super Troop Barrel.",
        "https://static.wikia.nocookie.net/clashofclans/images/1/1c/Super_Barbarian_info.png/revision/latest/scale-to-width-down/250?cb=20200401065036",
        "https://clashofclans.fandom.com/wiki/Super_Barbarian"
    ),
    Troop(
        "2",
        "Super Archer",
        "Having achieved serious arm strength, the Super Archer can now threaten targets several buildings away.",
        "You can have a maximum of 26 Super Archers at one time in a complete set of fully upgraded Army Camps. This number increases to 30 if you include the 4 that can fit into a fully upgraded Clan Castle. On the battlefield, you can clone an additional 12 Super Archers with four fully upgraded Clone Spells (three from the regular spell inventory and one from a max-level Clan Castle), for a total of 42 Super Archers.\n\nThe Super Archer is based upon the Magic Archer from Clash Royale. They even share the same bow and glowing eyes.\n\nIn the artwork, her hair is brighter. In battle, however, her hair is darker.\n\nThis is likely due to the lighting in the artwork.\n\nIn the description, it says that the Super Archer has gained serious arm strength. However, in both the artwork and in game, her arms are almost exactly the same as a normal Archer's and shows no sign of growth. \n\nIt is likely that the description refers to her improved arm agility or the fact that unlike the normal Archer, her arrows can pierce through buildings.\n\nLike the Giant Cannon and Spring Trap, any troop that would be one-shot by the Super Archer would be sent off flying off the map.\n\nSuper Archers were shown in the Party King skin release video and were originally a subject of debate as to whether it existed due to the fact that it had not been formally announced at that point. They had been present in game files since the June 2020 update (when the Inferno Dragon and Super Witch were made available).\n\nSuper Archers have a much bigger bow compared to their size than Archers do, about the size ratio of the Archer Queen and her modified X-Bow.\n\nThe color of the Super Archer's arrow has a similar color of the Level 8 X-Bow shots.",
        "https://static.wikia.nocookie.net/clashofclans/images/e/ea/Super_Archer_info.png/revision/latest/scale-to-width-down/250?cb=20201211020339",
        "https://clashofclans.fandom.com/wiki/Super_Archer"
    ),
    Troop(
        "3",
        "Sneaky Goblin",
        "Sneaky Goblins have a talent going unnoticed for a while after being deployed. It's usually the incredibly loud sound of resources being pilfered that gives them away.",
        "You can have a maximum of 106 Sneaky Goblins at one time in a complete set of fully upgraded Army Camps. This number increases to 122 if you include the 16 that can fit into a fully upgraded Clan Castle. On the battlefield, you can clone an additional 48 Sneaky Goblins with four fully upgraded Clone Spells (three from the regular spell inventory and one from a max-level Clan Castle), for a total of 170 Sneaky Goblins.\n\nIt bears a visual resemblance to the Goblin Brawler from Clash Royale.\n\nWith the orange mask he gains, the Sneaky Goblin resembles Michelangelo from Teenage Mutant Ninja Turtles series.\n\nThe name of this Super Troop corresponds to the Gold Storage's description, \"Don't let sneaky goblins anywhere near!\".\n\nIt should be noted that this description existed before the addition of the Sneaky Goblin, so \"sneaky\" could simply have been used here as an adjective.\n\nIn the artwork, the bag is darker than its patch. However, in battle, its patch is darker than the bag. Additionally, the hands in which the crowbar and bag are held are opposites between the two.\n\nIn the artwork, the Sneaky Goblin's mask and suspenders are darker. In battle, however, the Sneaky Goblin's mask and suspenders are brighter.",
        "https://static.wikia.nocookie.net/clashofclans/images/f/ff/Sneaky_Goblin_info.png/revision/latest/scale-to-width-down/250?cb=20201211014521",
        "https://clashofclans.fandom.com/wiki/Sneaky_Goblin"
    ),
    Troop(
        "4",
        "Super Wall Breaker",
        "Who knew that rolling was so much superior to running? Super Wall Breakers use pre-ignited bombs that blow up under all circumstances! No more duds!",
        "You can have a maximum of 40 Super Wall Breakers at one time in a complete set of fully upgraded Army Camps. This number increases to 46 if you include the 6 that can fit into a fully upgraded Clan Castle. On the battlefield, you can clone an additional 16 Super Wall Breakers with four level 6 or higher Clone Spells (three from the regular spell inventory and one from a max-level Clan Castle), for a total of 62 Super Wall Breakers.\n\nHowever, Super Wall Breakers are ineffective alone, so this is inadvisable.\n\nTheir bomb appears to be a bigger version of Level 6 Wall Breaker's bomb, with a stick of dynamite from level 7's bomb attached to the outside.\n\nIn the info image, the Super Wall Breaker's hat is brown and its gloves are orange, but in battle, its hat is red and its gloves are yellow.\n\nSurprisingly, the Super Wall Breaker has a smaller splash radius than its base counterpart, Wall Breaker.",
        "https://static.wikia.nocookie.net/clashofclans/images/b/b1/Super_Wall_Breaker_info.png/revision/latest/scale-to-width-down/250?cb=20200829085953",
        "https://clashofclans.fandom.com/wiki/Super_Wall_Breaker"
    ),
    Troop(
        "5",
        "Rocket Balloon",
        "Retrofitted with two carefully safety-inspected booster rockets, the Rocket Balloon gets a flying start to every battle!",
        "You can have a maximum of 40 Rocket Balloons at one time in a complete set of fully upgraded Army Camps. This number increases to 46 if you include the 6 that can fit into a fully upgraded Clan Castle. On the battlefield, you can clone an additional 16 Rocket Balloons with four level 6 or higher Clone Spells (three from the regular spell inventory and one from a max-level Clan Castle), for a total of 62 Rocket Balloons.\n\nThe rockets attached to the hot air balloon resemble the Rocket card from Clash Royale.\n\nThe silver platings that it has resembles how the level 8 Balloon gains them.\n\nThe Rocket Balloon's ability could be inspired by a Lavaloon strategy where players use Haste Spells on Balloons.\n\nThe chains and silver platings it has are darker in battle than in the info image.\n\nThe Rocket Balloon could be inspired by the Balloon in Clash of Clans – A Clashiversary Tale video where they celebrate 50th anniversary.\n\nUnlike the regular Balloon, the Rocket Balloon has sprites where it faces different directions rather than looking idle while moving. This may be due to the fact that its hot air balloon has two rockets on both sides and an empennage on the back of it.\n\nThe Rocket Balloon appears to have a Super Wall Breaker in it. This is based off of the fact that regular Balloons contain “promoted” Wall Breakers.",
        "https://static.wikia.nocookie.net/clashofclans/images/9/9e/Rocket_Balloon_info.png/revision/latest/scale-to-width-down/400?cb=20210614072633",
        "https://clashofclans.fandom.com/wiki/Rocket_Balloon"
    ),
    Troop(
        "6",
        "Super Wizard",
        "Super Wizard is positively charged with magical energy! He's either the smartest person in the room... or else he blows the whole room to bits.",
        "You can have a maximum of 32 Super Wizards at one time in a complete set of fully upgraded Army Camps. This number increases to 37 if you include the 5 that can fit into a fully upgraded Clan Castle. On the battlefield, you can clone an additional 12 Super Wizards with four level 5 or higher Clone Spells (three from the regular spell inventory and one from a max-level Clan Castle), for a total of 49 Super Wizards.\n\nThe Super Wizard is partly based on the Electro Wizard from Clash Royale, in the fact that it has electricity as its attacks.\n\nThis would technically complete the wizard trio of the Ice Wizard, Wizard, and Electro Wizard, as the normal Wizard would represent itself, the Ice Wizard represent itself, and the Super Wizard represents the Electro Wizard.\n\nSuper Wizard's eyes glow in the artwork, but remain normal in battle. Additionally, the robe is lighter in battle but that may be part to the lighting for the artwork.\n\nThe Super Wizard is 1 of 6 Super Troops to appear with a Super Troop logo, the others being the Rocket Balloon, Super Bowler, Super Giant, Super Valkyrie, and the Super Witch.\n\nThe Electro Dragon's charging sound can be heard coming from the Super Wizard in battle while he attacks.\n\nThe Super Wizard is 1 of 5 Super Troops to also be in Clan Capital, the others being the Rocket Balloon, Super Barbarian, Super Dragon, and the Super Giant.",
        "https://static.wikia.nocookie.net/clashofclans/images/5/5e/Super_Wizard_info.png/revision/latest/scale-to-width-down/250?cb=20201207182215",
        "https://clashofclans.fandom.com/wiki/Super_Wizard"
    ),
    Troop(
        "7",
        "Super Dragon",
        "Sometimes having a fire inside of you isn't enough. The Super Dragon has fires on the inside, outside, and if he gets to do his thing, all around him!",
        "The Super Dragon is a Super Troop based on the Dragon. It can be unlocked by boosting the Dragon when the Dragon is at least level 7.\n\nBoosting the Dragon requires 25,000 Dark Elixir or a Super Potion, and doing so allows the Dragon to be boosted for 3 days. The level of Super Dragon you obtain from the boost corresponds to the level of Dragon you have.\n\nThe Super Dragon is a dragon that shoots bursts of flames, similar to the Roaster defense in the Builder Base. Its flame bursts hit 10 times, each doing splash damage over a sizable area of effect (about 1-tile? radius).\n\nBecause of the level requirement, players require Town Hall 12 in order to boost Dragons into Super Dragons. However, players require a level 8 Clan Castle or greater in order to get donated one, meaning not many people can get one.\n\nSuper Dragons have no preferred target when attacking; they will simply attack the closest building. However, if they become aware of enemy Clan Castle troops, Heroes, or Skeleton Trap skeletons (either by being attacked themselves or by being near another friendly troop under attack), and can fight back against them, they will leave their previously targeted building and instead engage the enemy troops. Once all of the nearby enemy troops are defeated, the Super Dragons will proceed to attack the nearest structure.",
        "https://static.wikia.nocookie.net/clashofclans/images/f/f4/Super_Dragon_info.png/revision/latest/scale-to-width-down/400?cb=20211209092118",
        "https://clashofclans.fandom.com/wiki/Super_Dragon"
    ),
    Troop(
        "8",
        "Super Valkyrie",
        "Not only are Super Valkyries superior to regular Valkyries in every way, they're also way more angry!",
        "You can have a maximum of 16 Super Valkyries at one time in a complete set of fully upgraded Army Camps. This number increases to 18 if you include the 2 that can fit into a level 8 or higher Clan Castle. On the battlefield, you can clone an additional 4 Super Valkyries with four Clone Spells (three from the regular spell inventory and one from a max-level Clan Castle), for a total of 22 Super Valkyries.\n\nThe Super Valkyrie’s ability has the same mechanic as the Lumberjack from Clash Royale.",
        "https://static.wikia.nocookie.net/clashofclans/images/2/25/Super_Valkyrie_Info.png/revision/latest/scale-to-width-down/300?cb=20201011215025",
        "https://clashofclans.fandom.com/wiki/Super_Valkyrie"
    ),
    Troop(
        "9",
        "Super Witch",
        "Focused magic creates focused results. Instead of summoning hordes of tiny Skeletons, Super Witch summons just one really big skeleton with very formidable bone density.",
        "You can have a maximum of 8 Super Witches at one time in a complete set of fully upgraded Army Camps. This number increases to 9 if you include the 1 that can fit into a level 8 or higher Clan Castle.\n\nThe Super Witch was accidentally leaked by one of the developers, although nothing at all was known with the leak, only the existence.",
        "https://static.wikia.nocookie.net/clashofclans/images/7/7c/Super_Witch_info.png/revision/latest/scale-to-width-down/262?cb=20200904092133",
        "https://clashofclans.fandom.com/wiki/Super_Witch"
    ),
    Troop(
        "10",
        "Ice Hound",
        "Free from all the lava-induced indigestion, the Ice Hound is ready to freeze the flow of battle. Chill out, or else.",
        "You can have a maximum of 8 Ice Hounds at one time in a complete set of fully upgraded Army Camps. This number increases to 9 if you include the 1 that can fit into a level 8 or higher Clan Castle.\n\nIts death freeze particle is similar to the Ice Golem’s.\n\nThe Ice Hound charmingly appears with a scarf in the artwork, but in-game does not wear one and instead looks like a re-textured level 3 Lava Hound.",
        "https://static.wikia.nocookie.net/clashofclans/images/2/29/Ice_Hound_info.png/revision/latest/scale-to-width-down/250?cb=20201211021126",
        "https://clashofclans.fandom.com/wiki/Ice_Hound"
    ),
)