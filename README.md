# Battleship
by Tom Ole Haelbich
Semester-long assignment for programming 2, applied computer science at the HTW Berlin
****

## Description

- ### game field:
  - size: 10 x 10
  - Top:
    - A - J
  -  Left:
     - 1 - 10

- ### ships:
  - The ships must not collide with each other.
  -  The ships must not be built around corners or have protrusions.
  -  The ships may be placed on the edge.
  -  The ships must not be placed diagonally.
  - 10 ships:
  - -  |Ammount|Name|Size|
       |-------|----|----|
       |1|Battleship|5|
       |2|Cruiser|4|
       |3| Destroyer | 3|
       |4|Submarines | 3|

## Gameplay
 -  It is decided at random who will start.
 -  The first player shoots on the opponent's field first.
 -  The second player answers with hit, water or hit and sunk.
 -  When a hit occurs, the hit person marks the hit on his field, and the player who   made the hit marks the hit on an empty field.
    - The hit is marked in red.
 -  If you hit the water, it will be marked in blue on the empty field of the shooter.
 -  If all fields of a ship are hit, the ship is sunk. 
    - a sunk ship is marked in **not decided yet**
 -  the first person to sink all the other players' ships wins.

## Commands

should always be converted to lower case

- ### preparation:

  - `create game` (only for the host) **! maye not be necessary !**
  - `connect`
  - `<name>`
  - `ships`
  - - `place <ship name>`
  - - - `at (<x/y>) (<x/y>)`
  - `delete ship at start cords (<x/y>)`
  - `ready`

- ### game:
  - `fire (<x/y>)`
  
- ### game end:
    - - `play again`

