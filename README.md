# Lots of Names

WARNING - experimental

Generate not-so-believable names from input strings.  Collisions are about 1 every 10,000 inputs.

Sample Names from UUIDs:

```
Seilhymer Pellucid
Raycroft Fragging
Karl Cuteness Maczko
Lavonna Juggernaut
Burington Labrid
Preexchanging Ditmars
Waffness Filla
Montes Bovard
Waltner Megalecithal
Callipash Bidget
Joette Unanalogical
Siena Bits Biddlecome
Overlubricated Wuerz
Isologous Vahan
Lorca Tigertoes Vongsakda
Albeiro Jiujutsu
Vendaces Pooh Rosenbluth
Horsehair Shawgo
Sympodial Mydear Dekany
Ossenfort Bundist
```

# INSTALL

Binaries available via [maven](https://mvnrepository.com/artifact/tech.navicore/lotsofnames): - check for latest version

Update your `build.sbt` dependencies with:
```scala
// https://mvnrepository.com/artifact/tech.navicore/lotsofnames
libraryDependencies += "tech.navicore" %% "lotsofnames" % "0.1.1"
```

## USAGE

```scala
    val data = "1010020202993993938484885858577583939392929393AAKDKDKDKDKDKDKDKDKDD"
    val id = LotsOfPeople(data)
    assert(id == "Homeothermous Mykhaylo")
```

## OPS

### publish local

```console
sbt +publishLocalSigned
```

### publish to nexus staging

```console
export GPG_TTY=$(tty)
sbt +publishSigned
sbt sonatypeReleaseAll
```
