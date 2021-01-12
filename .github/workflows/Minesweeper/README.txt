Minesweeper

Madeline Boese
1/10/21

This is an independent study for St. Mary's College of Maryland computer
science department for the Wintrem 2020-2021 term.

The goal of this project was to recreate Minesweeper in a way that
makes it more accessible to people with poorer vision. The specific
problem was "losing track" of the 8 tiles that surround each tile.

The solution presented in this program was to add a feature to highlight
a section of tiles around a center point. The code also has a retry button
to better learn the game.
===================================

CONTROLS
Right click: Place mine
Left click:
	Press uncover tiles for uncover on left click
	Press place flag to place a flag on left click
	Press highlight tiles to highlight a section on left click

Clear highlights: Unhighlights all tiles
Retry: Retry the map
New Game: Create a new game


GOAL
Flag all mines and uncover all safe tiles

Mines will be denoted by surrounding tiles value. The value indicates
how many mines are around that tile. For example, a tile marked 3 when
uncovered has 3 mines in the 8 tiles that surround it.