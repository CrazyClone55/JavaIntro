## This is the PseudoCode

<h1>Print Location</h1>
<ol>
    <li>Print name, xloc, and yloc</li>
</ol>

<h1>Distance To</h1>
<ol>
    <li>Cache this robot location</li>
    <li>Cache other bot location</li>
    <li>compare locations to get distance</li>
    <li>return distance</li>
</ol>

<h1>Move Forward</h1>
<ol>
    <li>get direction in radians</li>
    <li>get change in x using cos(radians) * distance traveled</li>
    <li>get change in y using sin(radians) * distance traveled</li>
    <li>if either == a certain stupid number (2.4492935982947064E-16) set change to 0</li>
    <li>set x location to xlocation + change x</li>
    <li>set y location to ylocation + change y</li>
</ol>

<h1></h1>