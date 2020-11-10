package eu.kanade.tachiyomi.extension.all.madara

import android.annotation.SuppressLint
import eu.kanade.tachiyomi.annotations.Nsfw
import eu.kanade.tachiyomi.network.GET
import eu.kanade.tachiyomi.network.POST
import eu.kanade.tachiyomi.source.Source
import eu.kanade.tachiyomi.source.SourceFactory
import eu.kanade.tachiyomi.source.model.Filter
import eu.kanade.tachiyomi.source.model.FilterList
import eu.kanade.tachiyomi.source.model.Page
import eu.kanade.tachiyomi.source.model.SChapter
import eu.kanade.tachiyomi.source.model.SManga
import eu.kanade.tachiyomi.util.asJsoup
import okhttp3.CacheControl
import okhttp3.FormBody
import okhttp3.Headers
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.concurrent.TimeUnit

class MadaraFactory : SourceFactory {
    override fun createSources(): List<Source> = listOf(
        AllPornComic(),
        Hiperdex(),
        LilyManga(),
        ManwhaClub(),
        Toonily()
        // Removed by request of site owner
        // EarlyManga(),
        // MangaGecesi(),
        // MangaWOW(),
        // MangaStein(),
        // KnightNoScanlation(),
        // AhStudios(),
    )
}

class ManwhaClub : Madara("Manwha Club", "https://manhwa.club", "en")
                                   
@Nsfw
class AllPornComic : Madara("AllPornComic", "https://allporncomic.com", "en") {
    override fun popularMangaRequest(page: Int): Request = GET("$baseUrl/manga/page/$page/?m_orderby=views", headers)
    override fun latestUpdatesRequest(page: Int): Request = GET("$baseUrl/manga/page/$page/?m_orderby=latest", headers)
    override fun searchMangaNextPageSelector() = "a[rel=next]"
    override fun getGenreList() = listOf(
        Genre("3D", "3d"),
        Genre("Ahegao", "ahegao"),
        Genre("Alien Girl", "alien-girl"),
        Genre("Anal", "anal"),
        Genre("Anime", "anime"),
        Genre("Anthology", "anthology"),
        Genre("Artbook", "artbook"),
        Genre("BBW / Chubby / Fat Woman", "bbw"),
        Genre("BDSM", "bdsm"),
        Genre("Big Areolae", "big-areolae"),
        Genre("Big Ass", "big-ass"),
        Genre("Big Balls", "big-balls"),
        Genre("Big Breasts", "big-breasts"),
        Genre("Big Clit", "big-clit"),
        Genre("Big Nipples", "big-nipples"),
        Genre("Big Penis", "big-penis"),
        Genre("Bikini", "bikini"),
        Genre("Blackmail", "blackmail"),
        Genre("Blindfold", "blindfold"),
        Genre("Body Modification", "body-modification"),
        Genre("Body Swap", "body-swap"),
        Genre("Body Writing", "body-writing"),
        Genre("BodyStocking", "bodystocking"),
        Genre("Bodysuit", "bodysuit"),
        Genre("Bondage", "bondage"),
        Genre("Brain Fuck", "brain-fuck"),
        Genre("Cartoon", "cartoon"),
        Genre("Cheerleader", "cheerleader"),
        Genre("Chinese Dress", "chinese-dress"),
        Genre("Collar / Choker", "collar"),
        Genre("Comedy", "comedy"),
        Genre("Corruption", "corruption"),
        Genre("Corset", "corset"),
        Genre("Crotch Tattoo", "crotch-tattoo"),
        Genre("Dark Skin", "dark-skin"),
        Genre("Demon Girl / Succubus", "demon-girl"),
        Genre("Dick Growth", "dick-growth"),
        Genre("Dickgirl On Dickgirl", "dickgirl-on-dickgirl"),
        Genre("Dickgirl On Male", "dickgirl-on-male"),
        Genre("Dickgirls Only", "dickgirls-only"),
        Genre("Drugs", "drugs"),
        Genre("Drunk", "drunk"),
        Genre("Exhibitionism", "exhibitionism"),
        Genre("FFM Threesome", "ffm-threesome"),
        Genre("FFT Threesome", "fft-threesome"),
        Genre("Females Only", "females-only"),
        Genre("Femdom", "femdom"),
        Genre("Feminization", "feminization"),
        Genre("Full Body Tattoo", "full-body-tattoo"),
        Genre("Full Color", "full-color"),
        Genre("Futanari", "futanari"),
        Genre("Gender Bender", "gender-bender"),
        Genre("Glasses", "glasses"),
        Genre("Group", "group"),
        Genre("Gyaru", "gyaru"),
        Genre("Gyaru-OH", "gyaru-oh"),
        Genre("Harem", "harem"),
        Genre("Hentai", "hentai"),
        Genre("Human Pet", "human-pet"),
        Genre("Humiliation", "humiliation"),
        Genre("Impregnation", "impregnation"),
        Genre("Incest", "incest"),
        Genre("Interracial", "interracial"),
        Genre("Kimono", "kimono"),
        Genre("Latex", "latex"),
        Genre("Leash", "leash"),
        Genre("Lingerie", "lingerie"),
        Genre("Lolicon", "lolicon"),
        Genre("MILF", "milf"),
        Genre("MMF Threesome", "mmf-threesome"),
        Genre("MMT Threesome", "mmt-threesome"),
        Genre("Magical Girl", "magical-girl"),
        Genre("Maid", "maid"),
        Genre("Male On Dickgirl", "male-on-dickgirl"),
        Genre("Manhwa", "manhwa"),
        Genre("Military", "military"),
        Genre("Milking", "milking"),
        Genre("Mind Break", "mind-break"),
        Genre("Mind Control", "mind-control"),
        Genre("Monster Girl", "monster-girl"),
        Genre("Moral Degeneration", "moral-degeneration"),
        Genre("Muscle", "muscle"),
        Genre("Muscle Growth", "muscle-growth"),
        Genre("Nakadashi", "nakadashi"),
        Genre("Netorare", "netorare"),
        Genre("Netori", "netori"),
        Genre("Ninja", "ninja"),
        Genre("Nun", "nun"),
        Genre("Nurse", "nurse"),
        Genre("Orgy", "orgy"),
        Genre("Paizuri", "paizuri"),
        Genre("Pegging", "pegging"),
        Genre("Piercing", "piercing"),
        Genre("Pixie Cut", "pixie-cut"),
        Genre("Policewoman", "policewoman"),
        Genre("Possession", "possession"),
        Genre("Retro", "retro"),
        Genre("Ryona", "ryona"),
        Genre("School Swimsuit", "school-swimsuit"),
        Genre("Schoolboy Uniform", "schoolboy-uniform"),
        Genre("Schoolgirl Uniform", "schoolgirl-uniform"),
        Genre("Shared Senses", "shared-senses"),
        Genre("Shemale", "shemale"),
        Genre("Shibari", "shibari"),
        Genre("Shotacon", "shotacon"),
        Genre("Slave", "slave"),
        Genre("Slime Girl", "slime-girl"),
        Genre("Small Breasts", "small-breasts"),
        Genre("Stockings", "stockings"),
        Genre("Strap-on", "strap-on"),
        Genre("Stuck In Wall", "stuck-in-wall"),
        Genre("Superhero", "superhero"),
        Genre("Superheroine", "superheroine"),
        Genre("Tail", "tail"),
        Genre("Tail Plug", "tail-plug"),
        Genre("Tankoubon", "tankoubon"),
        Genre("Tentacles", "tentacles"),
        Genre("Thigh High Boots", "thigh-high-boots"),
        Genre("Tights", "tights"),
        Genre("Time Stop", "time-stop"),
        Genre("Tomboy", "tomboy"),
        Genre("Tomgirl", "tomgirl"),
        Genre("Torture", "torture"),
        Genre("Transformation", "transformation"),
        Genre("Uncensored", "uncensored"),
        Genre("Unusual Pupils", "unusual-pupils"),
        Genre("Unusual Teeth", "unusual-teeth"),
        Genre("Vampire", "vampire"),
        Genre("Virginity", "virginity"),
        Genre("Voyeurism", "voyeurism"),
        Genre("Webtoon", "webtoon"),
        Genre("Western", "western"),
        Genre("Witch", "witch"),
        Genre("Yandere", "yandere"),
        Genre("Yaoi", "yaoi"),
        Genre("Yuri", "yuri")
    )
}

class Hiperdex : Madara("Hiperdex", "https://hiperdex.com", "en") {
    override fun getGenreList() = listOf(
        Genre("Adult", "adult"),
        Genre("Action", "action"),
        Genre("Adventure", "adventure"),
        Genre("Bully", "bully"),
        Genre("Comedy", "comedy"),
        Genre("Drama", "drama"),
        Genre("Ecchi", "ecchi"),
        Genre("Fantasy", "fantasy"),
        Genre("Gender Bender", "gender-bender"),
        Genre("Harem", "harem"),
        Genre("Historical", "historical"),
        Genre("Horror", "horror"),
        Genre("Isekai", "isekai"),
        Genre("Josei", "josei"),
        Genre("Martial Arts", "martial-arts"),
        Genre("Mature", "mature"),
        Genre("Mystery", "mystery"),
        Genre("Psychological", "psychological"),
        Genre("Romance", "romance"),
        Genre("School Life", "school-life"),
        Genre("Sci-Fi", "sci-fi"),
        Genre("Seinen", "seinen"),
        Genre("Shoujo", "shoujo"),
        Genre("Shounen", "shounen"),
        Genre("Slice of Life", "slice-of-life"),
        Genre("Smut", "smut"),
        Genre("Sports", "sports"),
        Genre("Supernatural", "supernatural"),
        Genre("Thriller", "thriller"),
        Genre("Tragedy", "tragedy"),
        Genre("Yaoi", "yaoi"),
        Genre("Yuri", "yuri")
    )
}

@Nsfw
class Toonily : Madara("Toonily", "https://toonily.com", "en") {
    override fun getGenreList(): List<Genre> = listOf(
        Genre("Action", "action-webtoon"),
        Genre("Adult", "adult-webtoon"),
        Genre("Adventure", "adventure-webtoon"),
        Genre("Comedy", "comedy-webtoon"),
        Genre("Drama", "drama-webtoon"),
        Genre("Fantasy", "fantasy-webtoon"),
        Genre("Gender Bender", "gender-bender"),
        Genre("Gossip", "gossip"),
        Genre("Harem", "harem-webtoon"),
        Genre("Historical", "webtoon-historical"),
        Genre("Horror", "horror-webtoon"),
        Genre("Josei", "josei-manga"),
        Genre("Mature", "mature-webtoon"),
        Genre("Mystery", "mystery-webtoon"),
        Genre("NTR", "ntr-webtoon"),
        Genre("Psychological", "psychological-webtoon"),
        Genre("Romance", "romance-webtoon"),
        Genre("School life", "school-life-webtoon"),
        Genre("Sci-Fi", "scifi-webtoon"),
        Genre("Seinen", "seinen-webtoon"),
        Genre("Shoujo", "shoujo"),
        Genre("Shounen", "shounen-webtoon"),
        Genre("Slice of Life", "sliceoflife-webtoon"),
        Genre("Supernatural", "supernatural-webtoon"),
        Genre("Thriller", "thriller-webtoon"),
        Genre("Tragedy", "tragedy"),
        Genre("Vanilla", "vanilla-webtoon"),
        Genre("Yaoi", "yaoi-webtoon"),
        Genre("Yuri", "yuri-webtoon")
    )
}

class LilyManga : Madara("Lily Manga", "https://lilymanga.com", "en", SimpleDateFormat("yyyy-MM-dd", Locale.US))

