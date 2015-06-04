# PatternShooter

Our company has a task to create a new first-person shooter game. And here are the requirements for the game:

In the game we should have three kind of levels, for each level we have different game zone (or location in the map):

    Mountain zone
    Factory zone
    Under water zone

We have different kind of enemies, weapons and tools based on level zones as follows:
Mountain Zone
Characters:

    Mountain evil
    Baronom
    Icelander
    BigHook

Weapons and tools:

    Bombs
    Blast
    Gun
    Machine Gun
    Rockets 
    Pickax
    Rope
    Karabiner
    Armor


Factory Zone

Characters:

    Sulfurhead
    Slimeman
    Plasmodium
    Gorgonel


Weapons and tools:

    Bombs
    Blast
    Gun
    Machine Gun
    Chemical machine gun
    Cocktail molotov
    Gas Mask 
    Armor
    Glycerin balls


Under water Zone
Characters

    Dumbfishead
    Sharker
    Whalesknighter
    Deephellkraken
    Amphibianshipswrecker


Weapons and tools:

    Blast
    Watergun
    Net
    Harpoon
    Depth bomb
    Torpedo
    Armor
    BreathMask
    Underwaterscooter

Additional game details/requirements:

    Each character can have different abilities and strengths.
    In each zone every weapon or tool has its own (hidden) location, where to be found.
    Each character (including our hero) starts with a weapon based on his individuality and zone level, but while playing can change his weapon.
    Each character can use all the weapons described above for the given zone and only our hero can use the tools like armour, gas mask, breath mask etc.
    Our hero and all the enemies could combine all kind of weapons and can switch or combine them. For example our hero could use breathmask, armor, underwaterscooter and watergun together. (Take in mind that if the enemies are near to some of the weapons they will take it.)
    Some weapons like gun and blast can hit only one enemy, but some of the weapons like rockets or bombs can hit more than one.
    Weapons like blast machine gun and watergun could fire on continuously after switched on and than after that must be switched off to stop firing. (Does not require pressing the trigger each time to fire)
    We should be able to save the game at any time and if someone kills our hero to restore the game on previous state.


Use as much design patterns as you can.
Feel free to add additional requirements or functionality to the game if you like. For example you can have a game modes for a level with time and hits limit, when time expires and you don't have enough hits you loose the game. Or you can start the game with a goals for hits/kills. Also you can have statistics/history with your best game plays etc. 
