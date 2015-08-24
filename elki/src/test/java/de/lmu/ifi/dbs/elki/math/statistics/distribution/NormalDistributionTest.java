package de.lmu.ifi.dbs.elki.math.statistics.distribution;

/*
 This file is part of ELKI:
 Environment for Developing KDD-Applications Supported by Index-Structures

 Copyright (C) 2015
 Ludwig-Maximilians-Universität München
 Lehr- und Forschungseinheit für Datenbanksysteme
 ELKI Development Team

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU Affero General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU Affero General Public License for more details.

 You should have received a copy of the GNU Affero General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
import org.junit.Test;

/**
 * Unit test for the Normal distribution in ELKI.
 * 
 * The reference values were computed using GNU R and SciPy.
 * 
 * @author Erich Schubert
 * @since 0.5.0
 */
public class NormalDistributionTest extends AbstractDistributionTest {
  public static final double[] P_CDFPDF = { //
  0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7, 1.8, 1.9, 2.0, 1e-05, 1e-10, 0.1234567, 3.14159265359, 2.71828182846, 0.314159265359, 0.271828182846 //
  };

  public static final double[] SCIPY_NORM_CDF_0_1 = { //
  5.39827837277028987905680423864396288990974426269531e-01, // 0.100000
  5.79259709439102987715841663884930312633514404296875e-01, // 0.200000
  6.17911422188952563772090798011049628257751464843750e-01, // 0.300000
  6.55421741610324182225610911700641736388206481933594e-01, // 0.400000
  6.91462461274013118206482886307640001177787780761719e-01, // 0.500000
  7.25746882249926450469956762390211224555969238281250e-01, // 0.600000
  7.58036347776926966446353617357090115547180175781250e-01, // 0.700000
  7.88144601416603363119861569430213421583175659179688e-01, // 0.800000
  8.15939874653240471147341850155498832464218139648438e-01, // 0.900000
  8.41344746068542925776512220181757584214210510253906e-01, // 1.000000
  8.64333939053617328340806125197559595108032226562500e-01, // 1.100000
  8.84930329778291779874166422814596444368362426757812e-01, // 1.200000
  9.03199515414389697554042868432588875293731689453125e-01, // 1.300000
  9.19243340766228933524928379483753815293312072753906e-01, // 1.400000
  9.33192798731141914814202209527138620615005493164062e-01, // 1.500000
  9.45200708300442005160846292710630223155021667480469e-01, // 1.600000
  9.55434537241456993683641485404223203659057617187500e-01, // 1.700000
  9.64069680887074231812050584267126396298408508300781e-01, // 1.800000
  9.71283440183998147965382941038114950060844421386719e-01, // 1.900000
  9.77249868051820791414741051994496956467628479003906e-01, // 2.000000
  5.00003989422803996056643427436938509345054626464844e-01, // 0.000010
  5.00000000039894199055368062545312568545341491699219e-01, // 0.000000
  5.49127269841833243191331348498351871967315673828125e-01, // 0.123457
  9.99159841831736672546071531542111188173294067382812e-01, // 3.141593
  9.96718904163704344512098032282665371894836425781250e-01, // 2.718282
  6.23299960463814084477007781970314681529998779296875e-01, // 0.314159
  6.07122932952487870394975288945715874433517456054688e-01, // 0.271828
  };

  public static final double[] SCIPY_NORM_PDF_0_1 = { //
  3.96952547477011807863789272232679650187492370605469e-01, // 0.100000
  3.91042693975455879495939370826818048954010009765625e-01, // 0.200000
  3.81387815460524137733955285511910915374755859375000e-01, // 0.300000
  3.68270140303323334496354846123722381889820098876953e-01, // 0.400000
  3.52065326764299524331391921805334277451038360595703e-01, // 0.500000
  3.33224602891799670523198528826469555497169494628906e-01, // 0.600000
  3.12253933366761271539502331506810151040554046630859e-01, // 0.700000
  2.89691552761482729039244077284820377826690673828125e-01, // 0.800000
  2.66085249898754816477719487011199817061424255371094e-01, // 0.900000
  2.41970724519143365327522587904240936040878295898438e-01, // 1.000000
  2.17852177032550553548162497463636100292205810546875e-01, // 1.100000
  1.94186054983212980085127696838753763586282730102539e-01, // 1.200000
  1.71368592047807355438493459587334655225276947021484e-01, // 1.300000
  1.49727465635744877436863475850259419530630111694336e-01, // 1.400000
  1.29517595665891743772490940500574652105569839477539e-01, // 1.500000
  1.10920834679455543314574583746434655040502548217773e-01, // 1.600000
  9.40490773768869470217168782255612313747406005859375e-02, // 1.700000
  7.89501583008941493213583839860802982002496719360352e-02, // 1.800000
  6.56158147746765951779934766818769276142120361328125e-02, // 1.900000
  5.39909665131880628363703067407186608761548995971680e-02, // 2.000000
  3.98942280381485603335534051439026370644569396972656e-01, // 0.000010
  3.98942280401432702863218082711682654917240142822266e-01, // 0.000000
  3.95913584859803491244889528388739563524723052978516e-01, // 0.123457
  2.86914634635447975477551274536835990147665143013000e-03, // 3.141593
  9.91737923440347626802271463475335622206330299377441e-03, // 2.718282
  3.79733132751562452167348737930296920239925384521484e-01, // 0.314159
  3.84472192557199943241386108638835139572620391845703e-01, // 0.271828
  };

  public static final double[] GNUR_NORM_CDF_0_1 = { //
  5.39827837277028987905680423864396288990974426269531e-01, // 0.100000
  5.79259709439102987715841663884930312633514404296875e-01, // 0.200000
  6.17911422188952674794393260526703670620918273925781e-01, // 0.300000
  6.55421741610324182225610911700641736388206481933594e-01, // 0.400000
  6.91462461274013007184180423791985958814620971679688e-01, // 0.500000
  7.25746882249926450469956762390211224555969238281250e-01, // 0.600000
  7.58036347776926966446353617357090115547180175781250e-01, // 0.700000
  7.88144601416603363119861569430213421583175659179688e-01, // 0.800000
  8.15939874653240471147341850155498832464218139648438e-01, // 0.900000
  8.41344746068542925776512220181757584214210510253906e-01, // 1.000000
  8.64333939053617328340806125197559595108032226562500e-01, // 1.100000
  8.84930329778291779874166422814596444368362426757812e-01, // 1.200000
  9.03199515414389697554042868432588875293731689453125e-01, // 1.300000
  9.19243340766228933524928379483753815293312072753906e-01, // 1.400000
  9.33192798731141914814202209527138620615005493164062e-01, // 1.500000
  9.45200708300442005160846292710630223155021667480469e-01, // 1.600000
  9.55434537241456993683641485404223203659057617187500e-01, // 1.700000
  9.64069680887074231812050584267126396298408508300781e-01, // 1.800000
  9.71283440183998147965382941038114950060844421386719e-01, // 1.900000
  9.77249868051820791414741051994496956467628479003906e-01, // 2.000000
  5.00003989422803996056643427436938509345054626464844e-01, // 0.000010
  5.00000000039894199055368062545312568545341491699219e-01, // 0.000000
  5.49127269841833243191331348498351871967315673828125e-01, // 0.123457
  9.99159841831737227657583844120381399989128112792969e-01, // 3.141593
  9.96718904163713781407807346113258972764015197753906e-01, // 2.718282
  6.23299960463821967060482620581751689314842224121094e-01, // 0.314159
  6.07122932952524618777090381627203896641731262207031e-01, // 0.271828
  };

  public static final double[] GNUR_NORM_PDF_0_1 = { //
  3.96952547477011807863789272232679650187492370605469e-01, // 0.100000
  3.91042693975455879495939370826818048954010009765625e-01, // 0.200000
  3.81387815460524137733955285511910915374755859375000e-01, // 0.300000
  3.68270140303323334496354846123722381889820098876953e-01, // 0.400000
  3.52065326764299524331391921805334277451038360595703e-01, // 0.500000
  3.33224602891799670523198528826469555497169494628906e-01, // 0.600000
  3.12253933366761271539502331506810151040554046630859e-01, // 0.700000
  2.89691552761482729039244077284820377826690673828125e-01, // 0.800000
  2.66085249898754816477719487011199817061424255371094e-01, // 0.900000
  2.41970724519143365327522587904240936040878295898438e-01, // 1.000000
  2.17852177032550525792586881834722589701414108276367e-01, // 1.100000
  1.94186054983212952329552081209840252995491027832031e-01, // 1.200000
  1.71368592047807355438493459587334655225276947021484e-01, // 1.300000
  1.49727465635744877436863475850259419530630111694336e-01, // 1.400000
  1.29517595665891743772490940500574652105569839477539e-01, // 1.500000
  1.10920834679455543314574583746434655040502548217773e-01, // 1.600000
  9.40490773768869470217168782255612313747406005859375e-02, // 1.700000
  7.89501583008941493213583839860802982002496719360352e-02, // 1.800000
  6.56158147746765951779934766818769276142120361328125e-02, // 1.900000
  5.39909665131880628363703067407186608761548995971680e-02, // 2.000000
  3.98942280381485603335534051439026370644569396972656e-01, // 0.000010
  3.98942280401432702863218082711682654917240142822266e-01, // 0.000000
  3.95913584859803435733738297130912542343139648437500e-01, // 0.123457
  2.86914634635261405967709968933831987669691443443298e-03, // 3.141593
  9.91737923437773644108617077108647208660840988159180e-03, // 2.718282
  3.79733132751559954165543331328080967068672180175781e-01, // 0.314159
  3.84472192557189951234164482229971326887607574462891e-01, // 0.271828
  };

  public static final double[] SCIPY_NORM_CDF_1_3 = { //
  3.82088577811047380716757970731123350560665130615234e-01, // 0.100000
  3.94862910464025107515340096142608672380447387695312e-01, // 0.200000
  4.07751288296895331164648723643040284514427185058594e-01, // 0.300000
  4.20740290560896956773007104857242666184902191162109e-01, // 0.400000
  4.33816167389096341011622826044913381338119506835938e-01, // 0.500000
  4.46964883376386012958647597770323045551776885986328e-01, // 0.600000
  4.60172162722971012094319576135603711009025573730469e-01, // 0.700000
  4.73423535699634911999567066231975331902503967285156e-01, // 0.800000
  4.86704386182907899893734793295152485370635986328125e-01, // 0.900000
  5.00000000000000000000000000000000000000000000000000e-01, // 1.000000
  5.13295613817092100106265206704847514629364013671875e-01, // 1.100000
  5.26576464300365088000432933768024668097496032714844e-01, // 1.200000
  5.39827837277028987905680423864396288990974426269531e-01, // 1.300000
  5.53035116623614042552503633487503975629806518554688e-01, // 1.400000
  5.66183832610903658988377173955086618661880493164062e-01, // 1.500000
  5.79259709439102987715841663884930312633514404296875e-01, // 1.600000
  5.92248711703104668835351276356959715485572814941406e-01, // 1.700000
  6.05137089535974892484659903857391327619552612304688e-01, // 1.800000
  6.17911422188952563772090798011049628257751464843750e-01, // 1.900000
  6.30558659818236333371999080554815009236335754394531e-01, // 2.000000
  3.69442598126554777593355538556352257728576660156250e-01, // 0.000010
  3.69441340194343048608516255626454949378967285156250e-01, // 0.000000
  3.85074080732704326912596570764435455203056335449219e-01, // 0.123457
  7.62344427321841155986703597591258585453033447265625e-01, // 3.141593
  7.16596603378728214117643346980912610888481140136719e-01, // 2.718282
  4.09584635073669933724715974676655605435371398925781e-01, // 0.314159
  4.04109630623745164079707592463819310069084167480469e-01, // 0.271828
  };

  public static final double[] SCIPY_NORM_PDF_1_3 = { //
  1.27129271820174721829843633713608141988515853881836e-01, // 0.100000
  1.28335624865337977196233509857847820967435836791992e-01, // 0.200000
  1.29409556907848971585295316799602005630731582641602e-01, // 0.300000
  1.30347564658485293165313123608939349651336669921875e-01, // 0.400000
  1.31146572033979974536421764241822529584169387817383e-01, // 0.500000
  1.31803946961939227877635971708514261990785598754883e-01, // 0.600000
  1.32317515825670611873121629287197720259428024291992e-01, // 0.700000
  1.32685575437984065727547999813396017998456954956055e-01, // 0.800000
  1.32906902451659009178897008496278431266546249389648e-01, // 0.900000
  1.32980760133810910206264566113532055169343948364258e-01, // 1.000000
  1.32906902451659009178897008496278431266546249389648e-01, // 1.100000
  1.32685575437984065727547999813396017998456954956055e-01, // 1.200000
  1.32317515825670611873121629287197720259428024291992e-01, // 1.300000
  1.31803946961939227877635971708514261990785598754883e-01, // 1.400000
  1.31146572033979974536421764241822529584169387817383e-01, // 1.500000
  1.30347564658485293165313123608939349651336669921875e-01, // 1.600000
  1.29409556907848971585295316799602005630731582641602e-01, // 1.700000
  1.28335624865337977196233509857847820967435836791992e-01, // 1.800000
  1.27129271820174721829843633713608141988515853881836e-01, // 1.900000
  1.25794409230997744630897727802221197634935379028320e-01, // 2.000000
  1.25794549001942340682447252220299560576677322387695e-01, // 0.000010
  1.25794409232395459907749568628787528723478317260742e-01, // 0.000000
  1.27423930053037842702323700905253645032644271850586e-01, // 0.123457
  1.03069487463836984009191155564622022211551666259766e-01, // 3.141593
  1.12863271483980939779989682847372023388743400573730e-01, // 2.718282
  1.29550708126044883394811790822132024914026260375977e-01, // 0.314159
  1.29120619428010979801157986912585329264402389526367e-01, // 0.271828
  };

  public static final double[] GNUR_NORM_CDF_1_3 = { //
  3.82088577811047325205606739473296329379081726074219e-01, // 0.100000
  3.94862910464025163026491327400435693562030792236328e-01, // 0.200000
  4.07751288296895275653497492385213263332843780517578e-01, // 0.300000
  4.20740290560897012284158336115069687366485595703125e-01, // 0.400000
  4.33816167389096341011622826044913381338119506835938e-01, // 0.500000
  4.46964883376386012958647597770323045551776885986328e-01, // 0.600000
  4.60172162722971012094319576135603711009025573730469e-01, // 0.700000
  4.73423535699634911999567066231975331902503967285156e-01, // 0.800000
  4.86704386182907899893734793295152485370635986328125e-01, // 0.900000
  5.00000000000000000000000000000000000000000000000000e-01, // 1.000000
  5.13295613817092100106265206704847514629364013671875e-01, // 1.100000
  5.26576464300365088000432933768024668097496032714844e-01, // 1.200000
  5.39827837277028987905680423864396288990974426269531e-01, // 1.300000
  5.53035116623614042552503633487503975629806518554688e-01, // 1.400000
  5.66183832610903658988377173955086618661880493164062e-01, // 1.500000
  5.79259709439102987715841663884930312633514404296875e-01, // 1.600000
  5.92248711703104668835351276356959715485572814941406e-01, // 1.700000
  6.05137089535974892484659903857391327619552612304688e-01, // 1.800000
  6.17911422188952674794393260526703670620918273925781e-01, // 1.900000
  6.30558659818236333371999080554815009236335754394531e-01, // 2.000000
  3.69442598126554777593355538556352257728576660156250e-01, // 0.000010
  3.69441340194343048608516255626454949378967285156250e-01, // 0.000000
  3.85074080732704326912596570764435455203056335449219e-01, // 0.123457
  7.62344427321862472268776400596834719181060791015625e-01, // 3.141593
  7.16596603378836016773334449680987745523452758789062e-01, // 2.718282
  4.09584635073672598259975075052352622151374816894531e-01, // 0.314159
  4.04109630623757543066432162959245033562183380126953e-01, // 0.271828
  };

  public static final double[] GNUR_NORM_PDF_1_3 = { //
  1.27129271820174721829843633713608141988515853881836e-01, // 0.100000
  1.28335624865337977196233509857847820967435836791992e-01, // 0.200000
  1.29409556907848943829719701170688495039939880371094e-01, // 0.300000
  1.30347564658485293165313123608939349651336669921875e-01, // 0.400000
  1.31146572033979974536421764241822529584169387817383e-01, // 0.500000
  1.31803946961939227877635971708514261990785598754883e-01, // 0.600000
  1.32317515825670611873121629287197720259428024291992e-01, // 0.700000
  1.32685575437984065727547999813396017998456954956055e-01, // 0.800000
  1.32906902451659009178897008496278431266546249389648e-01, // 0.900000
  1.32980760133810910206264566113532055169343948364258e-01, // 1.000000
  1.32906902451659009178897008496278431266546249389648e-01, // 1.100000
  1.32685575437984065727547999813396017998456954956055e-01, // 1.200000
  1.32317515825670611873121629287197720259428024291992e-01, // 1.300000
  1.31803946961939227877635971708514261990785598754883e-01, // 1.400000
  1.31146572033979974536421764241822529584169387817383e-01, // 1.500000
  1.30347564658485293165313123608939349651336669921875e-01, // 1.600000
  1.29409556907848943829719701170688495039939880371094e-01, // 1.700000
  1.28335624865337977196233509857847820967435836791992e-01, // 1.800000
  1.27129271820174721829843633713608141988515853881836e-01, // 1.900000
  1.25794409230997716875322112173307687044143676757812e-01, // 2.000000
  1.25794549001942340682447252220299560576677322387695e-01, // 0.000010
  1.25794409232395459907749568628787528723478317260742e-01, // 0.000000
  1.27423930053037842702323700905253645032644271850586e-01, // 0.123457
  1.03069487463831918616641303287906339392066001892090e-01, // 3.141593
  1.12863271483960359020670694008003920316696166992188e-01, // 2.718282
  1.29550708126045049928265484595613088458776473999023e-01, // 0.314159
  1.29120619428011951246304533924558199942111968994141e-01, // 0.271828
  };

  public static final double[] SCIPY_NORM_CDF_01_01 = { //
  5.00000000000000000000000000000000000000000000000000e-01, // 0.100000
  8.41344746068542925776512220181757584214210510253906e-01, // 0.200000
  9.77249868051820791414741051994496956467628479003906e-01, // 0.300000
  9.98650101968369896532351503992686048150062561035156e-01, // 0.400000
  9.99968328758166880021462930017150938510894775390625e-01, // 0.500000
  9.99999713348428076464813329948810860514640808105469e-01, // 0.600000
  9.99999999013412299575520592043176293373107910156250e-01, // 0.700000
  9.99999999998720134897212119540199637413024902343750e-01, // 0.800000
  9.99999999999999333866185224906075745820999145507812e-01, // 0.900000
  1.00000000000000000000000000000000000000000000000000e+00, // 1.000000
  1.00000000000000000000000000000000000000000000000000e+00, // 1.100000
  1.00000000000000000000000000000000000000000000000000e+00, // 1.200000
  1.00000000000000000000000000000000000000000000000000e+00, // 1.300000
  1.00000000000000000000000000000000000000000000000000e+00, // 1.400000
  1.00000000000000000000000000000000000000000000000000e+00, // 1.500000
  1.00000000000000000000000000000000000000000000000000e+00, // 1.600000
  1.00000000000000000000000000000000000000000000000000e+00, // 1.700000
  1.00000000000000000000000000000000000000000000000000e+00, // 1.800000
  1.00000000000000000000000000000000000000000000000000e+00, // 1.900000
  1.00000000000000000000000000000000000000000000000000e+00, // 2.000000
  1.58679452213762561818555241188732907176017761230469e-01, // 0.000010
  1.58655254173427739949886472459184005856513977050781e-01, // 0.000000
  5.92727587424917268243973467178875580430030822753906e-01, // 0.123457
  1.00000000000000000000000000000000000000000000000000e+00, // 3.141593
  1.00000000000000000000000000000000000000000000000000e+00, // 2.718282
  9.83886862290707098210873482457827776670455932617188e-01, // 0.314159
  9.57127388891955366290176243637688457965850830078125e-01, // 0.271828
  };

  public static final double[] SCIPY_NORM_PDF_01_01 = { //
  3.98942280401432691760987836460117250680923461914062e+00, // 0.100000
  2.41970724519143365327522587904240936040878295898438e+00, // 0.200000
  5.39909665131880767141581145551754161715507507324219e-01, // 0.300000
  4.43184841193799972103306572535075247287750244140625e-02, // 0.400000
  1.33830225764885362219058784205572010250762104988098e-03, // 0.500000
  1.48671951473429788965346931561839483038056641817093e-05, // 0.600000
  6.07588284982330709772167754920135784857393446145579e-08, // 0.700000
  9.13472040836459525705208369548147081390387924670904e-11, // 0.800000
  5.05227108353689257466156274028694701290357130241127e-14, // 0.900000
  1.02797735716689157526658972936723696508848598985854e-17, // 1.000000
  7.69459862670641946739490369438934977209475249356985e-22, // 1.100000
  2.11881925350939881499454444092795876174188364829642e-26, // 1.200000
  2.14638373566309106931513939051468388983176710410808e-31, // 1.300000
  7.99882775700703797498824580100503753079025371215284e-37, // 1.400000
  1.09660655938900269201836083695141959890318473157378e-42, // 1.500000
  5.53070954984441600375694607190945207837912395256854e-49, // 1.600000
  1.02616307279193257019879511994839957950622370045046e-55, // 1.700000
  7.00418213431858258321746607183141912867315677743039e-63, // 1.800000
  1.75874954259520391793557171197265931013763303279246e-70, // 1.900000
  1.62463603677370066317505050197138645763358359341841e-78, // 2.000000
  2.41994921591514611236561904661357402801513671875000e+00, // 0.000010
  2.41970724761114075462842265551444143056869506835938e+00, // 0.000000
  3.88116637682825116328899639484006911516189575195312e+00, // 0.123457
  5.14979409860350480381150213015443214774639694748316e-201, // 3.141593
  5.46759448135644106738407952883081851114066212526125e-149, // 2.718282
  4.02700170728412354392844463291112333536148071289062e-01, // 0.314159
  9.11558359421968611435715956758940592408180236816406e-01, // 0.271828
  };

  public static final double[] GNUR_NORM_CDF_01_01 = { //
  5.00000000000000000000000000000000000000000000000000e-01, // 0.100000
  8.41344746068542925776512220181757584214210510253906e-01, // 0.200000
  9.77249868051820791414741051994496956467628479003906e-01, // 0.300000
  9.98650101968369896532351503992686048150062561035156e-01, // 0.400000
  9.99968328758166880021462930017150938510894775390625e-01, // 0.500000
  9.99999713348428076464813329948810860514640808105469e-01, // 0.600000
  9.99999999013412299575520592043176293373107910156250e-01, // 0.700000
  9.99999999998720134897212119540199637413024902343750e-01, // 0.800000
  9.99999999999999333866185224906075745820999145507812e-01, // 0.900000
  1.00000000000000000000000000000000000000000000000000e+00, // 1.000000
  1.00000000000000000000000000000000000000000000000000e+00, // 1.100000
  1.00000000000000000000000000000000000000000000000000e+00, // 1.200000
  1.00000000000000000000000000000000000000000000000000e+00, // 1.300000
  1.00000000000000000000000000000000000000000000000000e+00, // 1.400000
  1.00000000000000000000000000000000000000000000000000e+00, // 1.500000
  1.00000000000000000000000000000000000000000000000000e+00, // 1.600000
  1.00000000000000000000000000000000000000000000000000e+00, // 1.700000
  1.00000000000000000000000000000000000000000000000000e+00, // 1.800000
  1.00000000000000000000000000000000000000000000000000e+00, // 1.900000
  1.00000000000000000000000000000000000000000000000000e+00, // 2.000000
  1.58679452213762561818555241188732907176017761230469e-01, // 0.000010
  1.58655254173427739949886472459184005856513977050781e-01, // 0.000000
  5.92727587424917268243973467178875580430030822753906e-01, // 0.123457
  1.00000000000000000000000000000000000000000000000000e+00, // 3.141593
  1.00000000000000000000000000000000000000000000000000e+00, // 2.718282
  9.83886862290715424883558171131880953907966613769531e-01, // 0.314159
  9.57127388892042407775306855910457670688629150390625e-01, // 0.271828
  };

  public static final double[] GNUR_NORM_PDF_01_01 = { //
  3.98942280401432691760987836460117250680923461914062e+00, // 0.100000
  2.41970724519143365327522587904240936040878295898438e+00, // 0.200000
  5.39909665131880767141581145551754161715507507324219e-01, // 0.300000
  4.43184841193799972103306572535075247287750244140625e-02, // 0.400000
  1.33830225764885362219058784205572010250762104988098e-03, // 0.500000
  1.48671951473429755084029041389825920305156614631414e-05, // 0.600000
  6.07588284982330709772167754920135784857393446145579e-08, // 0.700000
  9.13472040836459267211266946726998684075171652807512e-11, // 0.800000
  5.05227108353689257466156274028694701290357130241127e-14, // 0.900000
  1.02797735716689157526658972936723696508848598985854e-17, // 1.000000
  7.69459862670641946739490369438934977209475249356985e-22, // 1.100000
  2.11881925350939881499454444092795876174188364829642e-26, // 1.200000
  2.14638373566309063140936928900934922616627232600929e-31, // 1.300000
  7.99882775700703797498824580100503753079025371215284e-37, // 1.400000
  1.09660655938900253270916972370619189601514495480260e-42, // 1.500000
  5.53070954984441600375694607190945207837912395256854e-49, // 1.600000
  1.02616307279193257019879511994839957950622370045046e-55, // 1.700000
  7.00418213431858258321746607183141912867315677743039e-63, // 1.800000
  1.75874954259520391793557171197265931013763303279246e-70, // 1.900000
  1.62463603677370042347322114173083210725409360385417e-78, // 2.000000
  2.41994921591514611236561904661357402801513671875000e+00, // 0.000010
  2.41970724761114031053921280545182526111602783203125e+00, // 0.000000
  3.88116637682825116328899639484006911516189575195312e+00, // 0.123457
  5.14979409827915730787384521426559029430228517673526e-201, // 3.141593
  5.46759447998955731091850416560450583665483609253997e-149, // 2.718282
  4.02700170728233830530484738119412213563919067382812e-01, // 0.314159
  9.11558359420472030798521245742449536919593811035156e-01, // 0.271828
  };

  public static final double[] P_PROBIT = { //
  0.0001, 0.001, 0.01, 0.1, 0.25, 0.5, 0.75, 0.9, 0.99, 0.999, 0.9999 //
  };

  public static final double[] SCIPY_NORM_PROBIT_0_1 = { //
  -3.71901648545568042081299608980771154165267944335938e+00, // 0.000100
  -3.09023230616781319213259848766028881072998046875000e+00, // 0.001000
  -2.32634787404084075745913651189766824245452880859375e+00, // 0.010000
  -1.28155156554460036844034220848698168992996215820312e+00, // 0.100000
  -6.74489750196081816469018122006673365831375122070312e-01, // 0.250000
  0.00000000000000000000000000000000000000000000000000e+00, // 0.500000
  6.74489750196081816469018122006673365831375122070312e-01, // 0.750000
  1.28155156554460036844034220848698168992996215820312e+00, // 0.900000
  2.32634787404084075745913651189766824245452880859375e+00, // 0.990000
  3.09023230616781319213259848766028881072998046875000e+00, // 0.999000
  3.71901648545570839843321664375253021717071533203125e+00, // 0.999900
  };

  public static final double[] GNUR_NORM_PROBIT_0_1 = { //
  -3.71901648545567997672378623974509537220001220703125e+00, // 0.000100
  -3.09023230616781319213259848766028881072998046875000e+00, // 0.001000
  -2.32634787404084075745913651189766824245452880859375e+00, // 0.010000
  -1.28155156554460036844034220848698168992996215820312e+00, // 0.100000
  -6.74489750196081705446715659491019323468208312988281e-01, // 0.250000
  0.00000000000000000000000000000000000000000000000000e+00, // 0.500000
  6.74489750196081705446715659491019323468208312988281e-01, // 0.750000
  1.28155156554460059048494713351828977465629577636719e+00, // 0.900000
  2.32634787404084075745913651189766824245452880859375e+00, // 0.990000
  3.09023230616781274804338863759767264127731323242188e+00, // 0.999000
  3.71901648545570839843321664375253021717071533203125e+00, // 0.999900
  };

  public static final double[] SCIPY_NORM_PROBIT_1_3 = { //
  -1.01570494563670408183497784193605184555053710937500e+01, // 0.000100
  -8.27069691850343957639779546298086643218994140625000e+00, // 0.001000
  -5.97904362212252227237740953569300472736358642578125e+00, // 0.010000
  -2.84465469663380110532102662546094506978988647460938e+00, // 0.100000
  -1.02346925058824567145165929105132818222045898437500e+00, // 0.250000
  1.00000000000000000000000000000000000000000000000000e+00, // 0.500000
  3.02346925058824567145165929105132818222045898437500e+00, // 0.750000
  4.84465469663380154941023647552356123924255371093750e+00, // 0.900000
  7.97904362212252227237740953569300472736358642578125e+00, // 0.990000
  1.02706969185034395763977954629808664321899414062500e+01, // 0.999000
  1.21570494563671260834780696313828229904174804687500e+01, // 0.999900
  };

  public static final double[] GNUR_NORM_PROBIT_1_3 = { //
  -1.01570494563670408183497784193605184555053710937500e+01, // 0.000100
  -8.27069691850343957639779546298086643218994140625000e+00, // 0.001000
  -5.97904362212252227237740953569300472736358642578125e+00, // 0.010000
  -2.84465469663380110532102662546094506978988647460938e+00, // 0.100000
  -1.02346925058824500531784451595740392804145812988281e+00, // 0.250000
  1.00000000000000000000000000000000000000000000000000e+00, // 0.500000
  3.02346925058824522736244944098871201276779174804688e+00, // 0.750000
  4.84465469663380154941023647552356123924255371093750e+00, // 0.900000
  7.97904362212252227237740953569300472736358642578125e+00, // 0.990000
  1.02706969185034395763977954629808664321899414062500e+01, // 0.999000
  1.21570494563671243071212302311323583126068115234375e+01, // 0.999900
  };

  public static final double[] SCIPY_NORM_PROBIT_01_01 = { //
  -2.71901648545568086490220593987032771110534667968750e-01, // 0.000100
  -2.09023230616781324764374971891811583191156387329102e-01, // 0.001000
  -1.32634787404084075745913651189766824245452880859375e-01, // 0.010000
  -2.81551565544600479462644671002635732293128967285156e-02, // 0.100000
  3.25510249803918211286557493622240144759416580200195e-02, // 0.250000
  1.00000000000000005551115123125782702118158340454102e-01, // 0.500000
  1.67448975019608203851362304703798145055770874023438e-01, // 0.750000
  2.28155156554460059048494713351828977465629577636719e-01, // 0.900000
  3.32634787404084086848143897441332228481769561767578e-01, // 0.990000
  4.09023230616781363622180833772290498018264770507812e-01, // 0.999000
  4.71901648545570817638861171872122213244438171386719e-01, // 0.999900
  };

  public static final double[] GNUR_NORM_PROBIT_01_01 = { //
  -2.71901648545568030979069362729205749928951263427734e-01, // 0.000100
  -2.09023230616781324764374971891811583191156387329102e-01, // 0.001000
  -1.32634787404084075745913651189766824245452880859375e-01, // 0.010000
  -2.81551565544600410073705631930351955816149711608887e-02, // 0.100000
  3.25510249803918350064435571766807697713375091552734e-02, // 0.250000
  1.00000000000000005551115123125782702118158340454102e-01, // 0.500000
  1.67448975019608176095786689074884634464979171752930e-01, // 0.750000
  2.28155156554460059048494713351828977465629577636719e-01, // 0.900000
  3.32634787404084086848143897441332228481769561767578e-01, // 0.990000
  4.09023230616781308111029602514463476836681365966797e-01, // 0.999000
  4.71901648545570873150012403129949234426021575927734e-01, // 0.999900
  };

  @Test
  public void testPDF() {
    checkPDF(new NormalDistribution(0., 1.), P_CDFPDF, SCIPY_NORM_PDF_0_1, 1e-11);
    checkPDF(new NormalDistribution(1., 3.), P_CDFPDF, SCIPY_NORM_PDF_1_3, 1e-12);
    checkPDF(new NormalDistribution(.1, .1), P_CDFPDF, SCIPY_NORM_PDF_01_01, 1e-11);
    checkPDF(new NormalDistribution(0., 1.), P_CDFPDF, GNUR_NORM_PDF_0_1, 1e-15);
    checkPDF(new NormalDistribution(1., 3.), P_CDFPDF, GNUR_NORM_PDF_1_3, 1e-15);
    checkPDF(new NormalDistribution(.1, .1), P_CDFPDF, GNUR_NORM_PDF_01_01, 1e-15);
  }

  @Test
  public void testCDF() {
    checkCDF(new NormalDistribution(0., 1.), P_CDFPDF, SCIPY_NORM_CDF_0_1, 1e-13);
    checkCDF(new NormalDistribution(1., 3.), P_CDFPDF, SCIPY_NORM_CDF_1_3, 1e-12);
    checkCDF(new NormalDistribution(.1, .1), P_CDFPDF, SCIPY_NORM_CDF_01_01, 1e-13);
    checkCDF(new NormalDistribution(0., 1.), P_CDFPDF, GNUR_NORM_CDF_0_1, 1e-15);
    checkCDF(new NormalDistribution(1., 3.), P_CDFPDF, GNUR_NORM_CDF_1_3, 1e-15);
    checkCDF(new NormalDistribution(.1, .1), P_CDFPDF, GNUR_NORM_CDF_01_01, 1e-15);
  }

  @Test
  public void testProbit() {
    // TODO: improve our implementation, to get more significant digits!
    checkQuantile(new NormalDistribution(0., 1.), P_PROBIT, SCIPY_NORM_PROBIT_0_1, 1e-8);
    checkQuantile(new NormalDistribution(1., 3.), P_PROBIT, SCIPY_NORM_PROBIT_1_3, 1e-9);
    checkQuantile(new NormalDistribution(.1, .1), P_PROBIT, SCIPY_NORM_PROBIT_01_01, 1e-9);
    checkQuantile(new NormalDistribution(0., 1.), P_PROBIT, GNUR_NORM_PROBIT_0_1, 1e-8);
    checkQuantile(new NormalDistribution(1., 3.), P_PROBIT, GNUR_NORM_PROBIT_1_3, 1e-9);
    checkQuantile(new NormalDistribution(.1, .1), P_PROBIT, GNUR_NORM_PROBIT_01_01, 1e-9);
  }
}