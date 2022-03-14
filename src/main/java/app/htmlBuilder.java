package app;

public class htmlBuilder {
    //Contains the html for the footer and navbar, so that they can be included into every other page.
    
    public static String addNavbar(String html){
        html = html + "<div class='topnav'>";
        html = html + "    <div class='flexbox'>";
        html = html + "        <a href='/page1.html'><img src='commonImages/logo_new.png' alt='Homefull' height = 35px style='object-fit: contain; border-radius: 0px;'></a>";
        html = html + "    </div>";
        html = html + "    <div class='flexbox' style='flex-grow: 100;'></div>";
        html = html + "    <div class='dropdown'>";
        html = html + "        <button class='dropbtn'>Big Picture</button>";
        html = html + "        <div class='dropdown-content'>";
        html = html + "            <a href='page1.html'>Home and Explore</a>";
        html = html + "            <a href='page2.html'>Three Big Facts</a>";
        html = html + "        </div>";
        html = html + "    </div>";
        html = html + "    <div class='dropdown'>";
        html = html + "        <button class='dropbtn'>Shallow Glance</button>";
        html = html + "        <div class='dropdown-content'>";
        html = html + "            <a href='page3.html'>Homelessness by Area</a>";
        html = html + "            <a href='page4.html'>People at Risk</a>";
        html = html + "        </div>";
        html = html + "    </div>";
        html = html + "    <div class='dropdown' style='margin-right: 120px;'>";
        html = html + "        <button class='dropbtn'>Deep Dive</button>";
        html = html + "        <div class='dropdown-content'>";
        html = html + "            <a href='page5.html'>Who Experiences Homelessness</a>";
        html = html + "            <a href='page6.html'>Change Over Time</a>";
        html = html + "        </div>";
        html = html + "    </div>";
        html = html + "</div>";

        return html;
    }


    public static String addFooter(String html){
        html = html + "    <div class='footer'>";
        html = html + "        <div class='flexbox' style='flex-grow: 3;'></div>";
        html = html + "        <div class='child'>";
        html = html + "            <h3>Legal</h3>";
        html = html + "            <ul>";
        html = html + "                <li>Usage</li>";
        html = html + "                <li>Cookies</li>";
        html = html + "            </ul>";
        html = html + "        </div>";
        html = html + "        <div class='flexbox' style='flex-grow: 3;'></div>";
        html = html + "        <div class='child'>";
        html = html + "            <h3>Learn</h4>";
        html = html + "            <ul>";
        html = html + "                <li><a href='https://www.sacredheartmission.org/about/what-is-homelessness'>What is Homelessness</a></li>";
        html = html + "                <li><a href='/page3.html'>Statistics</a></li>";
        html = html + "            </ul>";
        html = html + "        </div>";
        html = html + "        <div class='flexbox' style='flex-grow: 3;'></div>";
        html = html + "        <div class='child'>";
        html = html + "            <h3>Help</h4>";
        html = html + "            <ul>";
        html = html + "                <li>What can you do?</li>";
        html = html + "                <li><a href='https://www.homelessnessaustralia.org.au/are-you-experiencing-homelessness'>Support Services</a></li>";
        html = html + "            </ul>";
        html = html + "        </div>";
        html = html + "        <div class='flexbox' style='flex-grow: 3;'></div>";
        html = html + "        <div class='child'>";
        html = html + "            <h3>Contact</h3>";
        html = html + "            <ul>";
        html = html + "                <li>Raf Email</li>";
        html = html + "                <li>Ad Email</li>";
        html = html + "                <li>Phone</li>";
        html = html + "                <li>RMIT Address</li>";
        html = html + "            </ul>";
        html = html + "        </div>";
        html = html + "        <div class='flexbox' style='flex-grow: 3;'></div>";
        html = html + "    </div>";
        html = html + "</div>";

        return html;
    }
}
