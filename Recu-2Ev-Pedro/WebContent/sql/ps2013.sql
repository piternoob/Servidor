-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-03-2018 a las 19:04:45
-- Versión del servidor: 10.1.26-MariaDB
-- Versión de PHP: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ps2013`
--
CREATE DATABASE IF NOT EXISTS `ps2013` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `ps2013`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actuacion`
--

DROP TABLE IF EXISTS `actuacion`;
CREATE TABLE IF NOT EXISTS `actuacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) CHARACTER SET utf8mb4 NOT NULL,
  `origen` varchar(100) CHARACTER SET utf8mb4 NOT NULL,
  `descripcion` text CHARACTER SET utf8mb4 NOT NULL,
  `imagen` varchar(50) CHARACTER SET utf8mb4 NOT NULL,
  `url` varchar(200) CHARACTER SET utf8mb4 NOT NULL,
  `dia` int(11) NOT NULL,
  `visitas` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `dia` (`dia`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `actuacion`
--

INSERT INTO `actuacion` (`id`, `nombre`, `origen`, `descripcion`, `imagen`, `url`, `dia`, `visitas`) VALUES
(9, 'Delorean', 'España', 'A la espera de que aparezca su nuevo trabajo, cuya edición está prevista para el próximo mes de marzo, Delorean siguen apurando la ola en la que les subió “Subiza”, trabajo con el que acercaron su dance-rock a unos sonidos más sintetizados y con mayores texturas y que les abrió las puertas del reconocimiento internacional gracias a su fichaje por Matador, las elogiosas reseñas de Pitchfork y las giras por Estados Unidos. Alejados completamente de aquella banda que empezó sirviendo pop oscuro desde Zarautz, Delorean son ahora uno de los grupos más exportables y que mejor ha sabido interpretar los caminos de la música ', 'delorean.jpg', 'http://www.myspace.com/delorean', 1, 0),
(10, 'The Vaccines', 'Reino Unido', 'Fueron recibidos como el enésimo hype del pop británico y encumbrados por la prensa británica como tal, pero The Vaccines solo han necesitado dos discos para demostrar que no son flor de un día. Y no solo porque “What Did You Expect From The Vaccines” y “Come Of Age”, sus dos trabajos publicados hasta la fecha, esquiven las convenciones del revival brit para trazar conexiones entre Orange Juice y The Strokes, sino también porque la banda ha dado buena cuenta de su sabiduría musical compartiendo lanzamientos con R. Stevie Moore y versionando a Nick Lowe y Jonathan Richman.  ', 'vaccines.jpg', 'http://www.thevaccines.co.uk/es/home/', 1, 0),
(11, 'Animal Collective', 'Estados Unidos', 'Les dejamos con “Merriweather Post Pavilion”, álbum con el que imaginaban entre máquinas y cables el pop del futuro y que presentaron en el Primavera Sound de 2011 y aquí les tenemos de nuevo, convertidos en referente ineludible del nuevo pop independiente y presentando un nuevo álbum, “Centipede Hz”, que pone un poco más difícil la tarea de encasillarlos. Más alocados y vertiginosos que en su anterior trabajo, los de Baltimore han vuelto a tocar juntos y eso se ha trasladado a un disco febril y colorista que ellos mismos definen como su álbum de “garage roots”. Pensado especialmente para el directo, la puesta en escena de “Centipede Hz” promete convertirse en uno de los grandes momentos del festival.', 'animal.jpg', 'http://www.myanimalhome.net/', 2, 0),
(12, 'Deerhunter', 'Estados Unidos', 'En 2010, solo dos años después de publicar el celebrado “Microcastle”, Bradford Cox volvió a cambiarle la cara a Deerhunter para firmar “Halcyon Digest”, acaso el disco más accesible de los de Atlanta. Ahora, después de acercarse más que nunca al pop, Cox prepara un nuevo trabajo con el que, asegura, quiere explorar las raíces de la música americana siempre desde su propia perspectiva. Y todo mientras mantiene en activo proyectos como Atlas Sound y se encarga de comisariar la nueva edición del festival ATP.\r\n', 'deerhunter.jpg', 'http://4ad.com/artists/deerhunter', 2, 0),
(13, 'Grizzly Bear', 'Estados Unidos', 'Aunque hubo un tiempo en el que a Grizzly Bear se les comparaba insistentemente con Animal Collective, la banda de Brooklyn se ha ido despegando cada vez más de la sombra experimental de sus compañeros de quinta para trazar un camino propio en el que el pop luminoso y el folk retorcido han cobrado cada vez más protagonismo. Ahora, tres años después de entregar “Veckatimest”, uno de sus mejores trabajos, los estadounidenses han vuelto a pulir sus raíces y despejar sus canciones para publicar “Shields”, un hermoso disco de folk-pop con el que consiguen sonar originales sin necesidad de hacer ostentación experimental.', 'grizzly.jpg', 'http://grizzly-bear.net/', 2, 0),
(14, 'Phoenix', 'Francia', 'Si “Wolfgang Amadeus Phoenix”, disco que publicaron en 2009 y que ya presentaron ese mismo año en el Primavera Sound, les llevó a alinearse junto a Daft Punk y Air en la primera división de pop francés, “Bankrupt!”, su quinto y explícito trabajo, va camino de convertir a los los de Thomas Mars en nuevos héroes del vibrante rock sintetizado. Siguiendo el camino del pop de los ochenta y aligerando la crudeza de sus inicios con guiños a Azctec Camera y Prefab Sprout y reforzando la conexión entre pop directo y acabados electrónicos, los franceses estrenarán en Barcelona un disco que, según Mars, es “más experimental y minimalista” que sus predecesores. ', 'phoenix.jpg', 'http://www.wearephoenix.com/', 2, 0),
(15, 'The Postal Service', 'Estados Unidos', 'Justo cuando se cumplen diez años de la edición de aquella maravilla que fue “Give Up”, el disco que llevó a una nueva dimensión la llamada indietrónica y principio y fin de ese mano a mano entre Jimmy Tamborello (Dntel) y Ben Gibbard (Death Cab For Cutie), The Postal Service vuelve a la vida para conmemorar el décimo aniversario de su estreno y recuperar gemas pop servidas entre arreglos de electrónica microscópica y melancólica como “Such Great Heights”, “We Will Become Silhouettes” y “Sleepin In”.   ', 'postal.jpg', 'http://postalservicemusic.net/', 2, 0),
(16, 'Wild nothing', 'Estados Unidos', 'Jack Tatum, el hombre detrás de Wild Nothing, decidió cambiar su dormitorio por un estudio como Dios manda para grabar la continuación de “Gemini”, confeccionado a partir del software Garageband, y el resultado no podría haber sido mejor: pop atemporal y soleado, canciones repletas de nostalgia veraniega y sana melancolía, un sonido mucho más depurado y un emotivo homenaje al pop de los ochenta, facción C-86, en el que también caben guiños a The Cure o My Bloody Valentine.  \r\n', 'wild.jpg', 'http://www.myspace.com/wildnothing', 2, 0),
(17, 'Blur', 'Reino Unido', 'Alcanzaron la fama mundial en la década de los 90 gracias a discos como \"Parklife\" o \"The Great Escape\" y a rotundos éxitos del calibre de \"Girls & Boys\", \"Country House\" o \"Song 2\", trabajos que les convirtieron en el grupo pop de la década. Recientemente, Damon Albarn ha publicado el disco \"Dr Dee\" así como otros trabajos con los populares Gorillaz y The Good, The Bad And The Queen. Por su parte, Graham Coxon ha sacado varios discos en solitario. En los últimos años, Blur ha dosificado sus apariciones en directo. Y veintiún años después de su álbum de debut en 1991, el lanzamiento de \"Blur 21: The Box\" reúne su discografía al completo con la edición especial de una caja.', 'blur.jpg', 'http://www.blur.co.uk/', 3, 0),
(18, 'Nick Cave & The Bad Seeds', 'Australia', 'Cualquier noticia que tenga que ver con Nick Cave solo puede ser buena, pero si además llega acompañada de los Bad Seeds y de la promesa de un nuevo trabajo, la cosa mejora. Así, cinco años después de recuperar su faceta más canalla y volcánica en “Dig, Lazarus, Dig!!!”, el australiano recupera a sus compinches habituales para volver a sentar cátedra en lo que a rock oscuro, baladas mortuorias y canciones explosivas se refiere. Atrás queda, al menos de momento, Grinderman, las bandas sonoras y los coqueteos con la literatura; es la hora de Nick Cave, de los Bad Seeds y de “Push The Sky Away”, nuevo álbum de estudio que se suma a un brillante currículum jalonado por joyas como “The Boatman’s Call”, “Let Love In” o “Your Funeral… My Trial”. El lanzamiento de su nuevo álbum será el día 18 de febrero.', 'nick.jpg', 'http://www.nickcave.com/', 4, 0),
(19, 'Camera Obscura', 'Reino Unido', 'Supervivientes del indie escocés de los noventa, a Camera Obscura se les daba prácticamente por desaparecidos desde que publicaron el exquisito “My Maudlin Career”,  pero aquí están de nuevo, dispuestos a dejar de nuevo en nada cualquier comparación con Belle & Sebastian mientras desempolva espléndidos himnos como “Lloyd, I’m Ready To Be Heartbroken”. Con media decena de discos a sus espaldas y una historia que entronca con la edad dorada del pop escocés de los noventa, la banda liderada por la vocalista Tracyanne Campbell sigue siendo prácticamente infalible a la hora de manejar el pop clásico como material altamente emocional. ', 'camera.jpg', 'http://www.camera-obscura.net/', 4, 0),
(20, 'Band of Horses', 'Estados Unidos', 'Acaban de publicar su cuarto trabajo, “Mirage Rock”, y ya se han convertido en unos clásicos del rock americano. Nacidos al calor del sello Sub Pop, donde debutaron en 2006 con “Everything All The Time”, los de Seattle han visto como su popularidad crecía a medida que su sonido se empapaba de la tradición musical americana para acercarse a bandas como My Morning Jacket y sus canciones se hacían un hueco en bandas sonoras de películas. En 2010, su tercer trabajo, “Infinite Arms”, fue nominado a los premio Grammy.', 'horses.jpg', 'http://www.bandofhorses.com/us/home', 4, 0),
(21, 'Crystal Castles', 'Canadá', 'El tercer trabajo de Crystal Castles, escuetamente titulado como “(III)”, ha supuesto la consolidación absoluta de Alice Glass y Ethan Kath como grandes portavoces de una nueva generación electrónica que busca la incomodidad, el feísmo y el ruido como instrumentos para sacudir al público. Los de Toronto ya dieron mucho qué hablar con sus dos primeros trabajos, retorcidos artefactos de punk electrónico y disfuncional, pero en “(III)” rompen cualquier frontera imaginable para reforzar su nihilismo con puñetazos de trance, ritmos de 8bits y amenazantes susurros.', 'crystal.jpg', 'http://www.crystalcastles.com/', 4, 0),
(22, 'Dead Can Dance', 'Australia', 'Después de romper un silencio discográfico de 16 años con “Anastasis” y ofrecer una exitosa gira de presentación que les llevó a ofrecer una memorable actuación en L’Auditori de Barcelona, Lisa Gerrard y Brendan Perry siguen haciendo historia con su mezcla de músicas y culturas. Rara avis del sello 4AD, donde en los ochenta publicaron discos como “Into The Labirynth” y “Spleen And Ideal”, los australianos siempre han destacado por huir de las convenciones del pop para construir su característico e intransferible sonido capaz de combinar ambient, ritmos africanos, folclore europeo o art-rock. ', 'dead.jpg', 'http://www.deadcandance.com/main/', 4, 0),
(23, 'Los Planetas', 'España', 'Que el indie nacional empieza a tener sus propias leyendas es algo que saben bien Los Planetas, el más destacado e influyente grupo surgido en España en las últimas dos décadas y una de las células creativas más inquietas del pop contemporáneo. En esta ocasión, sin embargo, los granadinos aparcan sus nuevas aventuras a través del flamenco para celebrar el 15º aniversario de “Una semana en el motor de un autobús”, el disco más épico y amargo del indie nacional y álbum generacional por excelencia. Una ocasión inmejorable para reencontrarse con canciones como “Segundo Premio”, “La Playa” o “La Copa de Europa”. ', 'planetas.jpg', 'losplanetas.es', 4, 0),
(24, 'My Bloody Valentine', 'Irlanda', 'Imposible olvidar el desembarco de My Bloody Valentine en el Primavera Sound de 2009, aquellas dos actuaciones en las que los británicos se lanzaron sobre el público con su leyenda a cuestas y con “Loveless” como inmenso faro del noise-pop y el shoegaze. Cuatro años después de aquello, Kevin Shields y compañía regresan a los escenarios para seguir exprimiendo a volumen atronador el sonido que patentaron hace más de dos décadas y quien sabe si adelantar alguno de los temas de ese nuevo disco, el primero que publicarían desde 1991, que, tal y como ha asegurado Shields recientemente, podría estar listo en 2013. De momento, sin embargo, habrá que conformarse con la excelente reedición de “Loveless”, un clásico por el que no pasan los años.', 'bloody.jpg', 'http://www.mybloodyvalentine.org/', 4, 0),
(25, 'James Blake', 'Reino Unido', 'Talento precoz de la electrónica, James Blake nos dejó sin habla con su primer trabajo, un álbum publicado en 2011 en el que reinventaba el dubstep y el R&B a fuerza de cortar, pegar, inyectar samples y deformar un arco de influencias que va de Burial a Stevie Wonder. Ahora, dos años después de convertirse en el niño prodigio de la música urbana británica, el londinense ultima el lanzamiento de su segundo trabajo, previsto para marzo de 2013.', 'blake.jpg', 'http://jamesblakemusic.com/', 3, 0),
(26, 'La Bien Querida', 'España', 'Después de haberse hecho un hueco entre lo más destacado del indie nacional mezclando pop, flamenco y otras músicas de raíz española en “Romancero” y “Fiesta”, Ana Fernández-Villaverde cambia de tercio y, con la ayuda una vez más de David Rodríguez (La Estrella de David), se abona a los ritmos sintéticos, el krautrock y la música siniestra de los 80 en “Ceremonia”, su tercer trabajo. Un sorprendente cambio de rumbo que, sin embargo, mantiene intacta la personalidad de Ana gracias a unas letras afiladas y certeras. \r\n', 'bienquerida.jpg', 'http://www.myspace.com/labienquerida', 3, 0),
(27, 'The Knife', 'Suecia', 'El dúo formado por los hermanos Olof y Karin Dreijer se dio a conocer a principios de la década pasada con un debut que no tardó en convertirles en aventajados pupilos del pop electrónico con un pie en los ochenta y el otro en el techno. El magistral “Silent Shout”, su tercer álbum y uno de los más aplaudidos por la crítica, supuso un antes y un después en el sonido de una banda que, desde entonces, no ha parado quieta: en 2010 presentaron la ópera “Tomorrow In A Year” y Karin se estrenó en solitario como Fever Ray, aunque será este 2013 cuando la banda sueca presente por fin nuevo disco, un “Shake The Habitual” que Mute publicará en abril de 2013.', 'knife.jpg', 'http://theknife.net/', 3, 0),
(28, 'The Jesus and Mary Chain', 'Reino Unido', 'Padrinos involuntarios de todas aquellas bandas que han hecho del noise-pop su razón de ser, The Jesus & Mary Chain regresan para recordar una vez más que el original sigue siendo mejor que cualquier copia. Y en su caso, los originales hay que buscarlos en discos como “Psychocandy”, “Darklands” y “Automatic”, trabajos en los que los hermanos Reid se adueñaron del muro de sonido de Phil Spector para trasladar el pop ruidoso y retorcido a una nueva dimensión. Largamente reivindicados y convertidos en referencia ineludible del pop de las últimas décadas, los escoceses regresan a Barcelona después de su primera vuelta a la vida en 2007. ', 'jesus.jpg', 'http://thejesusandmarychain.co.uk/', 3, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dias`
--

DROP TABLE IF EXISTS `dias`;
CREATE TABLE IF NOT EXISTS `dias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dia` int(11) NOT NULL,
  `mes` int(11) NOT NULL,
  `año` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `dias`
--

INSERT INTO `dias` (`id`, `dia`, `mes`, `año`) VALUES
(1, 22, 5, 2013),
(2, 23, 5, 2013),
(3, 24, 5, 2013),
(4, 25, 5, 2013);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `info`
--

DROP TABLE IF EXISTS `info`;
CREATE TABLE IF NOT EXISTS `info` (
  `idioma` varchar(2) COLLATE utf8mb4_unicode_ci NOT NULL,
  `presentacion` text COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `info`
--

INSERT INTO `info` (`idioma`, `presentacion`) VALUES
('es', 'Primavera Sound es un festival músical que se celebra a finales de mayo en Barcelona. Desde sus inicios Primavera Sound ha centrado sus esfuerzos en ofrecer nuevas propuestas musicales del ámbito independiente junto a artistas de contrastada trayectoria, abarcando cualquier estilo o género, buscando primordialmente la calidad y apostando esencialmente por el pop, el rock y las tendencias más underground de la música electrónica y de baile. El festival ha contado a lo largo de su trayectoria con propuestas de los más diversos colores y estilos. Así lo demuestran los artistas que durante estos años han pasado por sus escenarios.'),
('en', 'Primavera Sound, or simply Primavera, is an annual music festival that take place in Barcelona, Spain in late May and, in some years, early June. The festival is held within the Parc del Fòrum leisure site—located approximately 6 km north east from the center of Barcelona—in the Diagonal Mar area of the Sant Martí district, by the coast of the Balearic Sea.The event is one of the largest music festivals in Spain, with an attendance rate of more than 100,000 over the course of the event in 2010. The festival is noted for its eclectic lineup, focus on independent music, and as a showcase for newly established international and domestic acts. The range of musical genres include alternative, indie, electronic, pop, hip hop, dance, folk, jazz, metal, and experimental music. ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `username` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombre` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`username`, `password`, `nombre`, `email`) VALUES
('adalovelace', 'adalovelace', 'Ada Lovelace', 'ada@mail.com'),
('almu_cerro', 'almu_cerro', 'Almudena Cerro', 'acerro@mail.com'),
('anabel', 'anabel', 'Anabel Miguel', 'anabel.miguel@informaticaldv.com'),
('ariego', 'ariego', 'Almudena Riego', 'almudena@mail.com'),
('bea', 'bea', 'Beatriz Torrón', 'bea@informatica.com'),
('emaroto', 'emaroto', 'Elisa Maroto', 'elisa.maroto@informaticaldv.com'),
('ljaen', 'ljaen', 'Laura de Jaén', 'laura@mail.com'),
('maite', 'maite', 'Maite Sánchez', 'msanchez@mail.com'),
('yolanda', 'yolanda', 'Yolanda Gallego ', 'yol@mail.com');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `actuacion`
--
ALTER TABLE `actuacion`
  ADD CONSTRAINT `actuacion_ibfk_1` FOREIGN KEY (`dia`) REFERENCES `dias` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
