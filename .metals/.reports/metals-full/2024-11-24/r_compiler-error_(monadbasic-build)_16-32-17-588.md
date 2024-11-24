file://<WORKSPACE>/Main.scala
### scala.reflect.internal.MissingRequirementError: class scala.Serializable in compiler mirror not found.

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 2.12.20
Classpath:

Options:
-deprecation -Wconf:cat=unused-nowarn:s -Wconf:cat=unused-nowarn:s -Xsource:3 -Yrangepos -Xplugin-require:semanticdb


action parameters:
offset: 9
uri: file://<WORKSPACE>/Main.scala
text:
```scala
object Ma@@

```



#### Error stacktrace:

```
scala.reflect.internal.MissingRequirementError$.signal(MissingRequirementError.scala:24)
	scala.reflect.internal.MissingRequirementError$.notFound(MissingRequirementError.scala:25)
	scala.reflect.internal.Mirrors$RootsBase.$anonfun$getModuleOrClass$5(Mirrors.scala:61)
	scala.reflect.internal.Mirrors$RootsBase.getRequiredClass(Mirrors.scala:61)
	scala.reflect.internal.Mirrors$RootsBase.requiredClass(Mirrors.scala:121)
	scala.reflect.internal.Definitions$DefinitionsClass.SerializableClass$lzycompute(Definitions.scala:409)
	scala.reflect.internal.Definitions$DefinitionsClass.SerializableClass(Definitions.scala:409)
	scala.reflect.internal.Definitions$DefinitionsClass.isPossibleSyntheticParent$lzycompute(Definitions.scala:1460)
	scala.reflect.internal.Definitions$DefinitionsClass.isPossibleSyntheticParent(Definitions.scala:1460)
	scala.tools.nsc.typechecker.Typers$Typer.fixDuplicateSyntheticParents(Typers.scala:1703)
	scala.tools.nsc.typechecker.Typers$Typer.typedParentTypes(Typers.scala:1713)
	scala.tools.nsc.typechecker.Namers$Namer.templateSig(Namers.scala:1150)
	scala.tools.nsc.typechecker.Namers$Namer.moduleSig(Namers.scala:1251)
	scala.tools.nsc.typechecker.Namers$Namer.memberSig(Namers.scala:1922)
	scala.tools.nsc.typechecker.Namers$Namer.typeSig(Namers.scala:1870)
	scala.tools.nsc.typechecker.Namers$Namer$MonoTypeCompleter.completeImpl(Namers.scala:877)
	scala.tools.nsc.typechecker.Namers$LockingTypeCompleter.complete(Namers.scala:2082)
	scala.tools.nsc.typechecker.Namers$LockingTypeCompleter.complete$(Namers.scala:2080)
	scala.tools.nsc.typechecker.Namers$TypeCompleterBase.complete(Namers.scala:2075)
	scala.reflect.internal.Symbols$Symbol.completeInfo(Symbols.scala:1542)
	scala.reflect.internal.Symbols$Symbol.info(Symbols.scala:1514)
	scala.reflect.internal.Symbols$Symbol.initialize(Symbols.scala:1698)
	scala.tools.nsc.typechecker.Typers$Typer.typed1(Typers.scala:5442)
	scala.tools.nsc.typechecker.Typers$Typer.typed(Typers.scala:5817)
	scala.tools.nsc.typechecker.Typers$Typer.typedStat$1(Typers.scala:5881)
	scala.tools.nsc.typechecker.Typers$Typer.$anonfun$typedStats$10(Typers.scala:3356)
	scala.tools.nsc.typechecker.Typers$Typer.typedStats(Typers.scala:3356)
	scala.tools.nsc.typechecker.Typers$Typer.typedPackageDef$1(Typers.scala:5449)
	scala.tools.nsc.typechecker.Typers$Typer.typed1(Typers.scala:5741)
	scala.tools.nsc.typechecker.Typers$Typer.typed(Typers.scala:5817)
	scala.tools.nsc.typechecker.Analyzer$typerFactory$TyperPhase.apply(Analyzer.scala:114)
	scala.tools.nsc.Global$GlobalPhase.applyPhase(Global.scala:465)
	scala.tools.nsc.interactive.Global$TyperRun.$anonfun$applyPhase$1(Global.scala:1341)
	scala.tools.nsc.interactive.Global$TyperRun.applyPhase(Global.scala:1341)
	scala.tools.nsc.interactive.Global$TyperRun.typeCheck(Global.scala:1334)
	scala.tools.nsc.interactive.Global.typeCheck(Global.scala:666)
	scala.meta.internal.pc.HoverProvider.typedHoverTreeAt(HoverProvider.scala:324)
	scala.meta.internal.pc.HoverProvider.hoverOffset(HoverProvider.scala:48)
	scala.meta.internal.pc.HoverProvider.hover(HoverProvider.scala:27)
	scala.meta.internal.pc.ScalaPresentationCompiler.$anonfun$hover$1(ScalaPresentationCompiler.scala:432)
```
#### Short summary: 

scala.reflect.internal.MissingRequirementError: class scala.Serializable in compiler mirror not found.