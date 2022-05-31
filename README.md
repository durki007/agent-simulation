agent simulation

# Usage
Pre production running:
```
gradle run --args="-n 8 -m 8 -d 20 -r (1,1,1)"
```
All the following flags are required:
<table>
<tr><td width="10%">-n</td><td> Int </td><td>X-Dimension of the board</td></tr>
<tr><td width="10%">-m</td><td> Int </td><<td>Y-Dimension of the board</td></tr>
<tr><td width="10%">-d</td><td> Int </td><<td>Duration of the simulation</td></tr>
<tr><td width="10%">-r</td><td> String : "(Int, Int, Int)" </td><td>Number of diffrent agent types per organisation - (BasicAgent, ScoutAgent, TankAgent) </td></tr>
</table>