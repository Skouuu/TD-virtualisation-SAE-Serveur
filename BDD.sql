12715197330881834557296147747242586312876226876348518005009967689923260634819638898
22859358253978742585447791039250102467293768121347706579095206690940202914227248043
73802082986695831031352683360931904328985022484939727594320126514390158523993347457
23540285104098973899709180954681547002246072798739330137600637274632754787897357097
94597347724542593218900895306384745042163736195655317565135954095822435115265345639
65151980376302303602604577002091467607018937454430945630696642447614031262315887740
2419295801972384008837284160442140577'),
(127,
'3163486890209313339204202770159590153722490239081780013397437176107848674842190739
14918149249083733649471039830359311702010382587147727929922619180203388904242595296
01659534130968402100008835781125093250583032125231601342231442520532952588076248522
60403175702122488950661813328261246174605516733763322189790870985597241795770142222
88341952677772608234613139857617044279507624293949943733234609446397605664402449317
94363675962112916710309011944663047572457501237009051961637012972008133344705044097
16821715476636496995231058027031286425250818860087721577669251976997579715033975587
5139884551633175966126728431127670267',
'8865183126292186306736277257266735163530091601926454060070087582750702566621708974
90671556818982744505753876834733315895693338902726028439355038899888975774221061987
01304739383413507167358574654002138192795977512327993851249043183998570028405122641
25084386732017095889844152675731937267794117350229953117859462972667191248718556104
83369326388982196195181661112400770364565249524402977342906830739796655575354791938
73888020557273255629021972268831732319359473095859818812040262094845218391426617992
56202804590957685229901038925873193759457038924714883817921490819200855177059788224
081171166507071330139466700923059195',
'1378716666995351025532344000093772997598192287962370083466290777576573799496861107
99254687973717940026762272259619105028681099018169399239166883332550981498594174238
18349608958752910848215986953028850141470930978818479115855267886038913064175069859
01376891824701616151789090263382126109616540543333648108512917864549523996439077969
72321540601114591728435759540006124670626228427521659022589273126554426064626493142
42965250275363006362972669375069107631673413538888129130469136127697089088642543473
29320194508409450459445790978632454413583197274201452510372058627939668435936489809
1938512638276529689876167515086989671'),
(128,
'1729721407522799752321476060076662755163551331385598931801038847679437604511450070
68457677937636310003352731768163536741505856692661174251835960200489667718288121789
75642804262676440199150566609921877556531088666507804532866083713722666370537088574
35721029852853191902213582458580788830363251279327304739654916793821492372374206129
46976911097980196180520586605264978642144455839933615407428610300623853355355975527
24286968181623682837520621009102587955054982263160097098200407784249626326763363067
96809954339209387077515683458087967076769637061668003242230191343239440569802087055
5109430032871819658707746167648858699',
'1432100810116488354336275175242731487007464344920503555877606524738478027099241761
94507285341641224464979855330357045909994724091001210597420669511412528388927337580
33230842770157878610712027119124577968809223667171149966434929435510640515954085714
13786724513420455976718359312594811728997172421751095709515909460110769528972250943
50812371297023376591572354467304737064165218873160758710051645168313129956219900372
71429783991258202802115647027562934703705587168893983098529111362490201270137232610
38559907888068038464523440662078778814484053535350925679616240503767682167771531698
9030545879222227916683266198250814957',
'1348585251725289443925108663540181977868632440981177286252552345177569085701199267
41598719493063840275409078278518437482434010441972523437132829837745016869241097970
35130388410733414677348202614426622676041424951200176018037745221743287314221108922
92169396322305019443128366478090547429300501717708075384503158600452857345380483957
33420271399663512392239647009135457372425616342000280353390337872014749833873282693
16623839353752539252540662728349051735461464909431438886304294693731748909441251764
01681207143767691205135505551969934278288312186842652084984443616644808592483512128
2407026471879432589423814276972287852');
-- --------------------------------------------------------
--
-- Structure de la table `question`
--
CREATE TABLE `question` (
`id` int NOT NULL,
`nom` varchar(250) NOT NULL,
`idResultat` int DEFAULT NULL,
`dateDebut` date NOT NULL,
`dateFin` date NOT NULL,
`idPublicKey` int DEFAULT NULL,
`traite` int NOT NULL DEFAULT '0',
`c1` text,
`c2` text,
`reponse1` text NOT NULL,
`reponse2` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
--
-- Déchargement des données de la table `question`
--
INSERT INTO `question` (`id`, `nom`, `idResultat`, `dateDebut`, `dateFin`,
`idPublicKey`, `traite`, `c1`, `c2`, `reponse1`, `reponse2`) VALUES
(77, 'toto est-il vivant ?', 64, '2023-03-27', '2017-01-18', 125, 1,
'8577024140158191195286254298711730530461056727253848583022447397262255267864435603
69050172811822636052647428336715521700909204523966971191763821457980320173132948006
02987900296644027224867081095659722087010228394231583795718598438162316513905340643
59861801187923155765767933398349406972752652113832488893089946252526261525482778886
47595953898888060673205172763157511546306826302871174784796043162295443645533336901
46516524699007449391090984529385475802367093506425466617053550314266097660122144821
19003562537137354664598340129785922073933523794781842093870974715186809969039914640
37617460932373549116934231651802283',
'5367354210140390867459760158984959601692978237381085662286412344591250064772567807
46374785917306778032254199191205089542865189786905891656164322549416005942102322478
41555169886948825488736079979400911927091427714362017185286209015263159688871023932
28799852038586524396037973850074763361770306466260452113754825992712352937070865048
96155025467469105386411468039012361202985956559127761686444838691451628410809956657
05222987251974080574906096243217052132655063212644732409598386636810916505555435745
17985895005508890342109276980807678407533783673355624094275169196583484894212314402
272463853224143960037961382590696275', 'oui', 'non'),
(78, 'ancien', 65, '2023-03-28', '1970-01-01', 128, 1,
'3238436465050311175856163394168997791482098519112443759336799203542313700776589746
93145188862528181591642301357388078979733271956591954589994509664546921344569695747
17469950034378976052588845441115747086119865247518711123548186072021026180517097839
51677352199788280954003079245906615287881926748680110491475820716404103941312616048
35905646397571394667556707901872454100003270981973596166942528252468171424545790443
77092696839066230969846045507356857210289364622642594786844537626281041259677833679
71111862070337900815356451197281556970598009888764023452983762063172931342664397904
437088393153015095006531124706475373',
'1116708452014031297559809788107100194470075026369365522518901371095844329723299997
86906729716212148990376414166212537653869370644845972727944292735491193189377354984
25924549461314720272003157512836758072466700581071380004492498574553789676013412822
58570017258254633662844696986751280121093990908277636606624494486807405098467557965
37995307399199633342700616255334302998000686517905803521914961361474378371770591977
79807488695036152287535633077250864894888404913454729875704376146127875488881268825
22406440878640674937116350627712990228023004256870684830810462909793301770869436188
9268516763715953262153603767877295958', 'o', 'n'),
(79, 'testr', 66, '2023-03-28', '2021-03-11', 128, 1,
'9495938860093171414504819063858677151725514509850418243762037705062761777018210588
04581939187577460347928657549581644340680812613702901941679408428947833411308637305
71852255705272380449545141758883729227889941925360347700305316585847104424061229246
24589514671945374548431466037739007014854396842704489340558433048295998922596827035
11325980924527736731793759188778675319616868921871417080531986782966391785303021107
70439131370255531569544444842066497353753388437333837649866630293623053191481286512
21362550531600331649618728064794920883857667720167342729590456066495253615733260358
067947586568063387985228232914512803',
'1152033013065224281590002207604726409024483586668655548785281842378655752923404847
06146613236097729624617058961973885272868678957218585701157847321970972835673185487
78585264452131955070164487893364076944260406393182045175979565999667036378164966176
01229941326729059189929017750792781094090395254616735338648459511986091593107204575
14889053262158497679077263701841309775293972333931355204994809933524275905878530361
75211779107631227905720042478032118377197231119949318415289424839465823231671012145
11832552239190828054006408029883858116106636357682114379437537737545046804752660067
5482212678376696027873794598897636378', 'a', 'b');
-- --------------------------------------------------------
--
-- Structure de la table `resultat`
--
CREATE TABLE `resultat` (
`id` int NOT NULL,
`reponse1` int NOT NULL,
`reponse2` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
--
-- Déchargement des données de la table `resultat`
--
INSERT INTO `resultat` (`id`, `reponse1`, `reponse2`) VALUES
(64, -1, 3),
(65, 200, -198),
(66, 100, -99);
-- --------------------------------------------------------
--
-- Structure de la table `SecretKey`
--
CREATE TABLE `SecretKey` (
`id` int NOT NULL,
`idPublicKey` int NOT NULL,
`secretKey` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
--
-- Déchargement des données de la table `SecretKey`
--
INSERT INTO `SecretKey` (`id`, `idPublicKey`, `secretKey`) VALUES
(59, 125,
'1150135254717385565123724403585191730563304173968461977097147780156241249745294010
03897388279044291867299032988383735617085690649682628066796472299251494984929137728
62789442759376029866280643080887962278101911076393413961304875751437834828268561936
22660339526627497121343811041689412791438718761976962543284665731180723407737479533
77166715415934106631039818010935377897454451986878272550796808127382280826257059205
66188074117977975568984543745213528011297656808274552421009987383627183508786513391
86914030156314941855771182278925251971834417851183967296490799940630763993872674148
3168559206456861502041728221315031335'),
(60, 126,
'1136458333351518418689568289459552906909022489522828422566543860112195658561855981
61142979546079727678771408470564426053566017727723286728382318221521243988402162982
76817107189688356922870840410597050940128897954531144865329864093978437088569943333
09068973178487489407724853387149866205655334047666872054046804548753689002019858665
28593805718803679325444095675684215491235078907639250259044294563881589150436682121
47537550922320536894773510012846061413859327283808407186894378983958643603311494212
75410088889908308575706785987636514544498112328021263326233358104288997692412039770
7921521263985943909375882855406457994'),
(61, 127,
'8768611114243903034019338037091889206646966910121264706092856302013570533890736211
78489470689800682373159455385675023789494217551160821739048796459609041238062025569
78162765443657261970988704413588662790817713105024771738615641089844309400506907980
30951745699088260146947968843195833908562388328264666571752259296580836607977280649
04731151770632745639656415398600305523638429997602339898021920137702682157578555790
04886667779852411335435100096465263407725904233622126683252394827776243829792482293
85436136046109302051873023410348231789212671945299551301746446149460761731808288500
83020848988233441783690929823631499'),
(62, 128,
'4370971356586251458191605179413201288679800606020480586052152489392081086117936955
41842751574625978544500146809188393463779488607306158208241601864990306177332689765
38483341201180218061624071101290830222205867277880615245091903307969519228405349422
56454494568712008671489428159874731764924208947838229845425540805801139670846070867
54412536536338342175171655182985444319788526814862222990335004371879210755274706892
22351034385987388604728020075358145242198288695256472284172660977701861044086846036
21361376150559065806413924461221159358742373655645760056856915414332637711515581733
8215870937517429995621287466610408');
-- --------------------------------------------------------
--
-- Structure de la table `user`
--
CREATE TABLE `user` (
`email` varchar(50) NOT NULL,
`password` text NOT NULL,
`role` varchar(50) NOT NULL,
`premiereConnexion` int NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
--
-- Déchargement des données de la table `user`
--
INSERT INTO `user` (`email`, `password`, `role`, `premiereConnexion`) VALUES
('admin',
'5a38afb1a18d408e6cd367f9db91e2ab9bce834cdad3da24183cc174956c20ce35dd39c2bd36aae907
111ae3d6ada353f7697a5f1a8fc567aae9e4ca41a9d19d', 'ROLE_ADMIN', 0),
('test@g.com',
'e78f8bc08e30d9149134c4df8fb3bfc9a7756fca073e0903b4691db9a3276c599e4561b2ef253a0b8e
12068ccb2aaf506ce51b796b7aed25dad2df9bba6808d3', 'ROLE_USER', 0),
('toto@gmail.com',
'3384c5bbefe1b541400c414d21dc34dae3dcbb7aaf25fb8896f8d6d246dc439632d2ab8e59035c0e31
6f38010ca366c0031c0a6e86f46c61244910ff2e8cd6a0', 'ROLE_USER', 0);
--
-- Index pour les tables déchargées
--
--
-- Index pour la table `AVote`
--
ALTER TABLE `AVote`
ADD PRIMARY KEY (`id`),
ADD KEY `fk_question` (`idQuestion`),
ADD KEY `fk_user_avote` (`idUser`);
--
-- Index pour la table `PublicKey`
--
ALTER TABLE `PublicKey`
ADD PRIMARY KEY (`id`);
--
-- Index pour la table `question`
--
ALTER TABLE `question`
ADD PRIMARY KEY (`id`),
ADD KEY `fk_question_resultat` (`idResultat`),
ADD KEY `fk_question_publicKey` (`idPublicKey`);
--
-- Index pour la table `resultat`
--
ALTER TABLE `resultat`
ADD PRIMARY KEY (`id`);
--
-- Index pour la table `SecretKey`
--
ALTER TABLE `SecretKey`
ADD PRIMARY KEY (`id`),
ADD KEY `fk_idPublicKey` (`idPublicKey`);
--
-- Index pour la table `user`
--
ALTER TABLE `user`
ADD PRIMARY KEY (`email`);
--
-- AUTO_INCREMENT pour les tables déchargées
--
--
-- AUTO_INCREMENT pour la table `AVote`
--
ALTER TABLE `AVote`
MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=136;
--
-- AUTO_INCREMENT pour la table `PublicKey`
--
ALTER TABLE `PublicKey`
MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=129;
--
-- AUTO_INCREMENT pour la table `question`
--
ALTER TABLE `question`
MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=80;
--
-- AUTO_INCREMENT pour la table `resultat`
--
ALTER TABLE `resultat`
MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;
--
-- AUTO_INCREMENT pour la table `SecretKey`
--
ALTER TABLE `SecretKey`
MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;
--
-- Contraintes pour les tables déchargées
--
--
-- Contraintes pour la table `AVote`
--
ALTER TABLE `AVote`
ADD CONSTRAINT `fk_question` FOREIGN KEY (`idQuestion`) REFERENCES `question`
(`id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `fk_user_avote` FOREIGN KEY (`idUser`) REFERENCES `user` (`email`)
ON DELETE CASCADE ON UPDATE CASCADE;
--
-- Contraintes pour la table `question`
--
ALTER TABLE `question`
ADD CONSTRAINT `fk_question_publicKey` FOREIGN KEY (`idPublicKey`) REFERENCES
`PublicKey` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
ADD CONSTRAINT `fk_question_resultat` FOREIGN KEY (`idResultat`) REFERENCES
`resultat` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
--
-- Contraintes pour la table `SecretKey`
--
ALTER TABLE `SecretKey`
ADD CONSTRAINT `fk_idPublicKey` FOREIGN KEY (`idPublicKey`) REFERENCES `PublicKey`
(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
