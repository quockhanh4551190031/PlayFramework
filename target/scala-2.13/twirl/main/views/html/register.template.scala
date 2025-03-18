
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

object register extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/()(implicit request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.37*/("""

"""),_display_(/*3.2*/main("Register")/*3.18*/ {_display_(Seq[Any](format.raw/*3.20*/("""
    """),format.raw/*4.5*/("""<h1>Register</h1>
    <form id="registerForm">
        """),_display_(/*6.10*/helper/*6.16*/.CSRF.formField),format.raw/*6.31*/("""
        """),format.raw/*7.9*/("""<div>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <button type="submit">Register</button>
    </form>
    <a href=""""),_display_(/*17.15*/routes/*17.21*/.HomeController.index()),format.raw/*17.44*/("""">Back to login</a>

    <script>
        document.getElementById('registerForm').addEventListener('submit', async (e) => """),format.raw/*20.89*/("""{"""),format.raw/*20.90*/("""
            """),format.raw/*21.13*/("""e.preventDefault();
            const token = document.querySelector('input[name="csrfToken"]').value;
            const formData = """),format.raw/*23.30*/("""{"""),format.raw/*23.31*/("""
                """),format.raw/*24.17*/("""username: document.getElementById('username').value,
                password: document.getElementById('password').value
            """),format.raw/*26.13*/("""}"""),format.raw/*26.14*/(""";

            try """),format.raw/*28.17*/("""{"""),format.raw/*28.18*/("""
                """),format.raw/*29.17*/("""const response = await fetch('/api/auth/register', """),format.raw/*29.68*/("""{"""),format.raw/*29.69*/("""
                    """),format.raw/*30.21*/("""method: 'POST',
                    headers: """),format.raw/*31.30*/("""{"""),format.raw/*31.31*/("""
                        """),format.raw/*32.25*/("""'Content-Type': 'application/json',
                        'Csrf-Token': token
                    """),format.raw/*34.21*/("""}"""),format.raw/*34.22*/(""",
                    body: JSON.stringify(formData)
                """),format.raw/*36.17*/("""}"""),format.raw/*36.18*/(""");

                const result = await response.json();

                if (response.ok) """),format.raw/*40.34*/("""{"""),format.raw/*40.35*/("""
                    """),format.raw/*41.21*/("""window.location.href = '/login';
                """),format.raw/*42.17*/("""}"""),format.raw/*42.18*/(""" """),format.raw/*42.19*/("""else """),format.raw/*42.24*/("""{"""),format.raw/*42.25*/("""
                    """),format.raw/*43.21*/("""// Display the error message from the server
                    alert(result.message || 'Registration failed');
                """),format.raw/*45.17*/("""}"""),format.raw/*45.18*/("""
            """),format.raw/*46.13*/("""}"""),format.raw/*46.14*/(""" """),format.raw/*46.15*/("""catch (error) """),format.raw/*46.29*/("""{"""),format.raw/*46.30*/("""
                """),format.raw/*47.17*/("""console.error('Error:', error);
            """),format.raw/*48.13*/("""}"""),format.raw/*48.14*/("""
        """),format.raw/*49.9*/("""}"""),format.raw/*49.10*/(""");
    </script>
""")))}),format.raw/*51.2*/(""" """))
      }
    }
  }

  def render(request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply()(request)

  def f:(() => (RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = () => (request) => apply()(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/register.scala.html
                  HASH: 704963f6578b18ff7c8c47566187ac0f7b535efd
                  MATRIX: 739->1|869->36|899->41|923->57|962->59|994->65|1078->123|1092->129|1127->144|1163->154|1574->538|1589->544|1633->567|1786->692|1815->693|1857->707|2019->841|2048->842|2094->860|2257->995|2286->996|2335->1017|2364->1018|2410->1036|2489->1087|2518->1088|2568->1110|2642->1156|2671->1157|2725->1183|2855->1285|2884->1286|2983->1357|3012->1358|3136->1454|3165->1455|3215->1477|3293->1527|3322->1528|3351->1529|3384->1534|3413->1535|3463->1557|3622->1688|3651->1689|3693->1703|3722->1704|3751->1705|3793->1719|3822->1720|3868->1738|3941->1783|3970->1784|4007->1794|4036->1795|4086->1815
                  LINES: 21->1|26->1|28->3|28->3|28->3|29->4|31->6|31->6|31->6|32->7|42->17|42->17|42->17|45->20|45->20|46->21|48->23|48->23|49->24|51->26|51->26|53->28|53->28|54->29|54->29|54->29|55->30|56->31|56->31|57->32|59->34|59->34|61->36|61->36|65->40|65->40|66->41|67->42|67->42|67->42|67->42|67->42|68->43|70->45|70->45|71->46|71->46|71->46|71->46|71->46|72->47|73->48|73->48|74->49|74->49|76->51
                  -- GENERATED --
              */
          