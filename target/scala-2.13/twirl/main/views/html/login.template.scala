
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

object login extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/()(implicit request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.37*/("""

"""),_display_(/*3.2*/main("Login")/*3.15*/ {_display_(Seq[Any](format.raw/*3.17*/("""
    """),format.raw/*4.5*/("""<h1>Login</h1>
    <form id="loginForm">
        """),_display_(/*6.10*/helper/*6.16*/.CSRF.formField),format.raw/*6.31*/("""
        """),format.raw/*7.9*/("""<div>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <button type="submit">Login</button>
    </form>
    <a href=""""),_display_(/*17.15*/routes/*17.21*/.HomeController.register()),format.raw/*17.47*/("""">Register</a>

    <script>
        document.getElementById('loginForm').addEventListener('submit', async (e) => """),format.raw/*20.86*/("""{"""),format.raw/*20.87*/("""
            """),format.raw/*21.13*/("""e.preventDefault();
            const token = document.querySelector('input[name="csrfToken"]').value;
            const formData = """),format.raw/*23.30*/("""{"""),format.raw/*23.31*/("""
                """),format.raw/*24.17*/("""username: document.getElementById('username').value,
                password: document.getElementById('password').value
            """),format.raw/*26.13*/("""}"""),format.raw/*26.14*/(""";

            try """),format.raw/*28.17*/("""{"""),format.raw/*28.18*/("""
                """),format.raw/*29.17*/("""const response = await fetch('/api/auth/login', """),format.raw/*29.65*/("""{"""),format.raw/*29.66*/("""
                    """),format.raw/*30.21*/("""method: 'POST',
                    headers: """),format.raw/*31.30*/("""{"""),format.raw/*31.31*/("""
                        """),format.raw/*32.25*/("""'Content-Type': 'application/json',
                        'Csrf-Token': token
                    """),format.raw/*34.21*/("""}"""),format.raw/*34.22*/(""",
                    body: JSON.stringify(formData)
                """),format.raw/*36.17*/("""}"""),format.raw/*36.18*/(""");

                const result = await response.json();

                if (response.ok) """),format.raw/*40.34*/("""{"""),format.raw/*40.35*/("""
                    """),format.raw/*41.21*/("""window.location.href = '/';
                """),format.raw/*42.17*/("""}"""),format.raw/*42.18*/(""" """),format.raw/*42.19*/("""else """),format.raw/*42.24*/("""{"""),format.raw/*42.25*/("""
                    """),format.raw/*43.21*/("""alert(result.message || 'Login failed');
                """),format.raw/*44.17*/("""}"""),format.raw/*44.18*/("""
            """),format.raw/*45.13*/("""}"""),format.raw/*45.14*/(""" """),format.raw/*45.15*/("""catch (error) """),format.raw/*45.29*/("""{"""),format.raw/*45.30*/("""
                """),format.raw/*46.17*/("""console.error('Error:', error);
            """),format.raw/*47.13*/("""}"""),format.raw/*47.14*/("""
        """),format.raw/*48.9*/("""}"""),format.raw/*48.10*/(""");
    </script>
""")))}),format.raw/*50.2*/(""" """))
      }
    }
  }

  def render(request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply()(request)

  def f:(() => (RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = () => (request) => apply()(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/login.scala.html
                  HASH: a0c775f9b9b8f1739b34e810b25347b0f90763ef
                  MATRIX: 736->1|866->36|896->41|917->54|956->56|988->62|1066->114|1080->120|1115->135|1151->145|1559->526|1574->532|1621->558|1766->675|1795->676|1837->690|1999->824|2028->825|2074->843|2237->978|2266->979|2315->1000|2344->1001|2390->1019|2466->1067|2495->1068|2545->1090|2619->1136|2648->1137|2702->1163|2832->1265|2861->1266|2960->1337|2989->1338|3113->1434|3142->1435|3192->1457|3265->1502|3294->1503|3323->1504|3356->1509|3385->1510|3435->1532|3521->1590|3550->1591|3592->1605|3621->1606|3650->1607|3692->1621|3721->1622|3767->1640|3840->1685|3869->1686|3906->1696|3935->1697|3985->1717
                  LINES: 21->1|26->1|28->3|28->3|28->3|29->4|31->6|31->6|31->6|32->7|42->17|42->17|42->17|45->20|45->20|46->21|48->23|48->23|49->24|51->26|51->26|53->28|53->28|54->29|54->29|54->29|55->30|56->31|56->31|57->32|59->34|59->34|61->36|61->36|65->40|65->40|66->41|67->42|67->42|67->42|67->42|67->42|68->43|69->44|69->44|70->45|70->45|70->45|70->45|70->45|71->46|72->47|72->47|73->48|73->48|75->50
                  -- GENERATED --
              */
          