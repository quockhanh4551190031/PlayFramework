
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object follows extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(username: String)(implicit request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.53*/("""

"""),_display_(/*3.2*/main("Follows")/*3.17*/ {_display_(Seq[Any](format.raw/*3.19*/("""
    """),format.raw/*4.5*/("""<div class="header">
        <h1>"""),_display_(/*5.14*/username),format.raw/*5.22*/("""'s Network</h1>
        <div>
            <a href=""""),_display_(/*7.23*/routes/*7.29*/.HomeController.index()),format.raw/*7.52*/("""" class="btn">Home</a>
            <a href=""""),_display_(/*8.23*/routes/*8.29*/.HomeController.logout()),format.raw/*8.53*/("""" class="logout-btn">Logout</a>
        </div>
    </div>

    <div class="content">
        """),_display_(/*13.10*/helper/*13.16*/.CSRF.formField),format.raw/*13.31*/("""
        """),format.raw/*14.9*/("""<div class="follows-container">
            <div class="followers-section">
                <h2>Followers</h2>
                <div id="followersList" class="users-list"></div>
            </div>
            <div class="following-section">
                <h2>Following</h2>
                <div id="followingList" class="users-list"></div>
            </div>
        </div>
    </div>

    <script>
        async function loadFollowers() """),format.raw/*27.40*/("""{"""),format.raw/*27.41*/("""
            """),format.raw/*28.13*/("""const token = document.querySelector('input[name="csrfToken"]').value;
            try """),format.raw/*29.17*/("""{"""),format.raw/*29.18*/("""
                """),format.raw/*30.17*/("""const response = await fetch('/api/followers', """),format.raw/*30.64*/("""{"""),format.raw/*30.65*/("""
                    """),format.raw/*31.21*/("""headers: """),format.raw/*31.30*/("""{"""),format.raw/*31.31*/("""
                        """),format.raw/*32.25*/("""'Csrf-Token': token
                    """),format.raw/*33.21*/("""}"""),format.raw/*33.22*/("""
                """),format.raw/*34.17*/("""}"""),format.raw/*34.18*/(""");
                const followers = await response.json();
                console.log(followers);
                const followersList = document.getElementById('followersList');
                followersList.innerHTML = followers.map(user => `
                    <div class="user-item">
                        <span class="username">$"""),format.raw/*40.49*/("""{"""),format.raw/*40.50*/("""user.username"""),format.raw/*40.63*/("""}"""),format.raw/*40.64*/("""</span>
                    </div>
                `).join('');
            """),format.raw/*43.13*/("""}"""),format.raw/*43.14*/(""" """),format.raw/*43.15*/("""catch (error) """),format.raw/*43.29*/("""{"""),format.raw/*43.30*/("""
                """),format.raw/*44.17*/("""console.error('Error loading followers:', error);
            """),format.raw/*45.13*/("""}"""),format.raw/*45.14*/("""
        """),format.raw/*46.9*/("""}"""),format.raw/*46.10*/("""

        """),format.raw/*48.9*/("""async function loadFollowing() """),format.raw/*48.40*/("""{"""),format.raw/*48.41*/("""
            """),format.raw/*49.13*/("""const token = document.querySelector('input[name="csrfToken"]').value;
            try """),format.raw/*50.17*/("""{"""),format.raw/*50.18*/("""
                """),format.raw/*51.17*/("""const response = await fetch('/api/following', """),format.raw/*51.64*/("""{"""),format.raw/*51.65*/("""
                    """),format.raw/*52.21*/("""headers: """),format.raw/*52.30*/("""{"""),format.raw/*52.31*/("""
                        """),format.raw/*53.25*/("""'Csrf-Token': token
                    """),format.raw/*54.21*/("""}"""),format.raw/*54.22*/("""
                """),format.raw/*55.17*/("""}"""),format.raw/*55.18*/(""");
                const following = await response.json();
                const followingList = document.getElementById('followingList');
                followingList.innerHTML = following.map(user => `
                    <div class="user-item">
                        <span class="username">$"""),format.raw/*60.49*/("""{"""),format.raw/*60.50*/("""user.username"""),format.raw/*60.63*/("""}"""),format.raw/*60.64*/("""</span>
                        <button onclick="unfollowUser($"""),format.raw/*61.56*/("""{"""),format.raw/*61.57*/("""user.id"""),format.raw/*61.64*/("""}"""),format.raw/*61.65*/(""")" class="unfollow-btn">Unfollow</button>
                    </div>
                `).join('');
            """),format.raw/*64.13*/("""}"""),format.raw/*64.14*/(""" """),format.raw/*64.15*/("""catch (error) """),format.raw/*64.29*/("""{"""),format.raw/*64.30*/("""
                """),format.raw/*65.17*/("""console.error('Error loading following:', error);
            """),format.raw/*66.13*/("""}"""),format.raw/*66.14*/("""
        """),format.raw/*67.9*/("""}"""),format.raw/*67.10*/("""

        """),format.raw/*69.9*/("""async function unfollowUser(userId) """),format.raw/*69.45*/("""{"""),format.raw/*69.46*/("""
            """),format.raw/*70.13*/("""const token = document.querySelector('input[name="csrfToken"]').value;
            try """),format.raw/*71.17*/("""{"""),format.raw/*71.18*/("""
                """),format.raw/*72.17*/("""const response = await fetch(`/api/follow/$"""),format.raw/*72.60*/("""{"""),format.raw/*72.61*/("""userId"""),format.raw/*72.67*/("""}"""),format.raw/*72.68*/("""`, """),format.raw/*72.71*/("""{"""),format.raw/*72.72*/("""
                    """),format.raw/*73.21*/("""method: 'DELETE',
                    headers: """),format.raw/*74.30*/("""{"""),format.raw/*74.31*/("""
                        """),format.raw/*75.25*/("""'Csrf-Token': token
                    """),format.raw/*76.21*/("""}"""),format.raw/*76.22*/("""
                """),format.raw/*77.17*/("""}"""),format.raw/*77.18*/(""");

                if (response.ok) """),format.raw/*79.34*/("""{"""),format.raw/*79.35*/("""
                    """),format.raw/*80.21*/("""loadFollowing();
                """),format.raw/*81.17*/("""}"""),format.raw/*81.18*/(""" """),format.raw/*81.19*/("""else """),format.raw/*81.24*/("""{"""),format.raw/*81.25*/("""
                    """),format.raw/*82.21*/("""alert('Failed to unfollow user');
                """),format.raw/*83.17*/("""}"""),format.raw/*83.18*/("""
            """),format.raw/*84.13*/("""}"""),format.raw/*84.14*/(""" """),format.raw/*84.15*/("""catch (error) """),format.raw/*84.29*/("""{"""),format.raw/*84.30*/("""
                """),format.raw/*85.17*/("""console.error('Error:', error);
            """),format.raw/*86.13*/("""}"""),format.raw/*86.14*/("""
        """),format.raw/*87.9*/("""}"""),format.raw/*87.10*/("""

        """),format.raw/*89.9*/("""loadFollowers();
        loadFollowing();
    </script>
""")))}),format.raw/*92.2*/(""" """))
      }
    }
  }

  def render(username:String,request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(username)(request)

  def f:((String) => (RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (username) => (request) => apply(username)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/follows.scala.html
                  HASH: b47014ac02e1d02e78088710cad953c5d936b3e2
                  MATRIX: 745->1|891->52|921->57|944->72|983->74|1015->80|1076->115|1104->123|1184->177|1198->183|1241->206|1313->252|1327->258|1371->282|1497->381|1512->387|1548->402|1585->412|2065->864|2094->865|2136->879|2252->967|2281->968|2327->986|2402->1033|2431->1034|2481->1056|2518->1065|2547->1066|2601->1092|2670->1133|2699->1134|2745->1152|2774->1153|3146->1497|3175->1498|3216->1511|3245->1512|3352->1591|3381->1592|3410->1593|3452->1607|3481->1608|3527->1626|3618->1689|3647->1690|3684->1700|3713->1701|3752->1713|3811->1744|3840->1745|3882->1759|3998->1847|4027->1848|4073->1866|4148->1913|4177->1914|4227->1936|4264->1945|4293->1946|4347->1972|4416->2013|4445->2014|4491->2032|4520->2033|4851->2336|4880->2337|4921->2350|4950->2351|5042->2415|5071->2416|5106->2423|5135->2424|5276->2537|5305->2538|5334->2539|5376->2553|5405->2554|5451->2572|5542->2635|5571->2636|5608->2646|5637->2647|5676->2659|5740->2695|5769->2696|5811->2710|5927->2798|5956->2799|6002->2817|6073->2860|6102->2861|6136->2867|6165->2868|6196->2871|6225->2872|6275->2894|6351->2942|6380->2943|6434->2969|6503->3010|6532->3011|6578->3029|6607->3030|6674->3069|6703->3070|6753->3092|6815->3126|6844->3127|6873->3128|6906->3133|6935->3134|6985->3156|7064->3207|7093->3208|7135->3222|7164->3223|7193->3224|7235->3238|7264->3239|7310->3257|7383->3302|7412->3303|7449->3313|7478->3314|7517->3326|7607->3386
                  LINES: 21->1|26->1|28->3|28->3|28->3|29->4|30->5|30->5|32->7|32->7|32->7|33->8|33->8|33->8|38->13|38->13|38->13|39->14|52->27|52->27|53->28|54->29|54->29|55->30|55->30|55->30|56->31|56->31|56->31|57->32|58->33|58->33|59->34|59->34|65->40|65->40|65->40|65->40|68->43|68->43|68->43|68->43|68->43|69->44|70->45|70->45|71->46|71->46|73->48|73->48|73->48|74->49|75->50|75->50|76->51|76->51|76->51|77->52|77->52|77->52|78->53|79->54|79->54|80->55|80->55|85->60|85->60|85->60|85->60|86->61|86->61|86->61|86->61|89->64|89->64|89->64|89->64|89->64|90->65|91->66|91->66|92->67|92->67|94->69|94->69|94->69|95->70|96->71|96->71|97->72|97->72|97->72|97->72|97->72|97->72|97->72|98->73|99->74|99->74|100->75|101->76|101->76|102->77|102->77|104->79|104->79|105->80|106->81|106->81|106->81|106->81|106->81|107->82|108->83|108->83|109->84|109->84|109->84|109->84|109->84|110->85|111->86|111->86|112->87|112->87|114->89|117->92
                  -- GENERATED --
              */
          