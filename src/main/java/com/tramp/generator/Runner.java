package com.tramp.generator;

import com.tramp.generator.common.CodeCreator;
import com.tramp.generator.common.MySqlContext;
import com.tramp.generator.entity.DBTable;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

/**
 * @author chenjm1
 * @since 2017/10/24
 */
public class Runner {
    private final static Logger log = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        if (args.length != 1) {
            log.error("args length accept 1");
            System.exit(0);
        }
        run(args[0]);
    }

    public static void run(String configPath) {
        if (StringUtils.isBlank(configPath)) {
            log.error("configPath is null");
            System.exit(0);
        }
        try {
            execute(configPath);
            //打印
            log.info(getIcon());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private static void execute(String configPath) {
        MySqlContext mySqlContext = new MySqlContext(configPath);
        List<DBTable> tableList = mySqlContext.getTableList();
        CodeCreator codeCreator = new CodeCreator();
        for (DBTable table : tableList) {
            codeCreator.generator(table);
        }
        mySqlContext.clear();
    }


    private static String getIcon() {
        String a1 = "//\n" +
                "//                       .::::.\n" +
                "//                     .::::::::.\n" +
                "//                    :::::::::::\n" +
                "//                 ..:::::::::::'\n" +
                "//              '::::::::::::'\n" +
                "//                .::::::::::\n" +
                "//           '::::::::::::::..\n" +
                "//                ..::::::::::::.\n" +
                "//              ``::::::::::::::::\n" +
                "//               ::::``:::::::::'        .:::.\n" +
                "//              ::::'   ':::::'       .::::::::.\n" +
                "//            .::::'      ::::     .:::::::'::::.\n" +
                "//           .:::'       :::::  .:::::::::' ':::::.\n" +
                "//          .::'        :::::.:::::::::'      ':::::.\n" +
                "//         .::'         ::::::::::::::'         ``::::.\n" +
                "//     ...:::           ::::::::::::'              ``::.\n" +
                "//    ```` ':.          ':::::::::'                  ::::..\n" +
                "//                       '.:::::'                    ':'````..\n" +
                "//            不见满街漂亮妹，哪个归得程序员？                 //\\n\" +\n" +
                "////////////////////////////////////////////////////////////////////\";";

        String a2 = "////////////////////////////////////////////////////////////////////\n" +
                "//                          _ooOoo_                               //\n" +
                "//                         o8888888o                              //\n" +
                "//                         88\" . \"88                              //\n" +
                "//                         (| ^_^ |)                              //\n" +
                "//                         O\\  =  /O                              //\n" +
                "//                      ____/`---'\\____                           //\n" +
                "//                    .'  \\\\|     |//  `.                         //\n" +
                "//                   /  \\\\|||  :  |||//  \\                        //\n" +
                "//                  /  _||||| -:- |||||-  \\                       //\n" +
                "//                  |   | \\\\\\  -  /// |   |                       //\n" +
                "//                  | \\_|  ''\\---/''  |   |                       //\n" +
                "//                  \\  .-\\__  `-`  ___/-. /                       //\n" +
                "//                ___`. .'  /--.--\\  `. . ___                     //\n" +
                "//              .\"\" '<  `.___\\_<|>_/___.'  >'\"\".                  //\n" +
                "//            | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |                 //\n" +
                "//            \\  \\ `-.   \\_ __\\ /__ _/   .-` /  /                 //\n" +
                "//      ========`-.____`-.___\\_____/___.-`____.-'========         //\n" +
                "//                           `=---='                              //\n" +
                "//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //\n" +
                "//            佛祖保佑       永无BUG     永不修改                 //\n" +
                "////////////////////////////////////////////////////////////////////";

        String a3 = "  .--,       .--,\n" +
                " ( (  \\.---./  ) )\n" +
                "  '.__/o   o\\__.'\n" +
                "     {=  ^  =}\n" +
                "      >  -  <\n" +
                "     /       \\\n" +
                "    //       \\\\\n" +
                "   //|   .   |\\\\\n" +
                "   \"'\\       /'\"_.-~^`'-.\n" +
                "      \\  _  /--'         `\n" +
                "    ___)( )(___\n" +
                "   (((__) (__)))    高山仰止,景行行止.虽不能至,心向往之。\n";

        String a4 = "/**\n" +
                " **************************************************************\n" +
                " *                                                            *\n" +
                " *   .=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-.       *\n" +
                " *    |                     ______                     |      *\n" +
                " *    |                  .-\"      \"-.                  |      *\n" +
                " *    |                 /            \\                 |      *\n" +
                " *    |     _          |              |          _     |      *\n" +
                " *    |    ( \\         |,  .-.  .-.  ,|         / )    |      *\n" +
                " *    |     > \"=._     | )(__/  \\__)( |     _.=\" <     |      *\n" +
                " *    |    (_/\"=._\"=._ |/     /\\     \\| _.=\"_.=\"\\_)    |      *\n" +
                " *    |           \"=._\"(_     ^^     _)\"_.=\"           |      *\n" +
                " *    |               \"=\\__|IIIIII|__/=\"               |      *\n" +
                " *    |              _.=\"| \\IIIIII/ |\"=._              |      *\n" +
                " *    |    _     _.=\"_.=\"\\          /\"=._\"=._     _    |      *\n" +
                " *    |   ( \\_.=\"_.=\"     `--------`     \"=._\"=._/ )   |      *\n" +
                " *    |    > _.=\"                            \"=._ <    |      *\n" +
                " *    |   (_/                                    \\_)   |      *\n" +
                " *    |                                                |      *\n" +
                " *    '-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-='      *\n" +
                " *                                                            *\n" +
                " *           奔驰宝马贵者趣，公交自行程序员                     *\n" +
                " **************************************************************\n" +
                " */\n";

        String a5 = "#     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "#\n" +
                "#       程序人员写程序，又拿程序换酒钱\n" +
                "#\n" +
                "# 　　　┏┓　　　┏┓\n" +
                "# 　　┏┛┻━━━┛┻┓\n" +
                "# 　　┃　　　　　　　 ┃\n" +
                "# 　　┃　　　━　　　 ┃\n" +
                "# 　　┃　┳┛　┗┳　┃\n" +
                "# 　　┃　　　　　　　 ┃\n" +
                "# 　　┃　　　┻　　　 ┃\n" +
                "# 　　┃　　　　　　　 ┃\n" +
                "# 　　┗━┓　　　┏━┛Codes are far away from bugs with the animal protecting\n" +
                "# 　　　　┃　　　┃    神兽保佑,代码无bug\n" +
                "# 　　　　┃　　　┃\n" +
                "# 　　　　┃　　　┗━━━┓\n" +
                "# 　　　　┃　　　　　 ┣┓\n" +
                "# 　　　　┃　　　　 ┏┛\n" +
                "# 　　　　┗┓┓┏━┳┓┏┛\n" +
                "# 　　　　　┃┫┫　┃┫┫\n" +
                "# 　　　　　┗┻┛　┗┻┛";

        String a6 = "#        ┏┓　　　┏┓+ +\n" +
                "#　　　┏┛┻━━━┛┻┓ + +\n" +
                "#　　　┃　　　　　　　┃ 　\n" +
                "#　　　┃　　　━　　　┃ ++ + + +\n" +
                "#　　 ████━████ ┃+\n" +
                "#　　　┃　　　　　　　┃ +\n" +
                "#　　　┃　　　┻　　　┃\n" +
                "#　　　┃　　　　　　　┃ + +\n" +
                "#　　　┗━┓　　　┏━┛\n" +
                "#　　　　　┃　　　┃　　　　　　　　　　　\n" +
                "#　　　　　┃　　　┃ + + + +\n" +
                "#　　　　　┃　　　┃　　　　Codes are far away from bugs with the animal protecting　　　\n" +
                "#　　　　　┃　　　┃ + 　　　　神兽保佑,永无bug 　　\n" +
                "#　　　　　┃　　　┃\n" +
                "#　　　　　┃　　　┃　　+　　　　　　　　　\n" +
                "#　　　　　┃　 　　┗━━━┓ + +\n" +
                "#　　　　　┃ 　　　　　　　┣┓\n" +
                "#　　　　　┃ 　　　　　　　┏┛\n" +
                "#　　　　　┗┓┓┏━┳┓┏┛ + + + +\n" +
                "#　　　　　　┃┫┫　┃┫┫\n" +
                "#　　　　　　┗┻┛　┗┻┛+ + + +";

        String a7 = "#                                                    __----~~~~~~~~~~~------___\n" +
                "#                                   .  .   ~~//====......          __--~ ~~\n" +
                "#                   -.            \\_|//     |||\\\\  ~~~~~~::::... /~\n" +
                "#                ___-==_       _-~o~  \\/    |||  \\\\            _/~~-\n" +
                "#        __---~~~.==~||\\=_    -_--~/_-~|-   |\\\\   \\\\        _/~\n" +
                "#    _-~~     .=~    |  \\\\-_    '-~7  /-   /  ||    \\      /\n" +
                "#  .~       .~       |   \\\\ -_    /  /-   /   ||      \\   /\n" +
                "# /  ____  /         |     \\\\ ~-_/  /|- _/   .||       \\ /\n" +
                "# |~~    ~~|--~~~~--_ \\     ~==-/   | \\~--===~~        .\\\n" +
                "#          '         ~-|      /|    |-~\\~~       __--~~\n" +
                "#                      |-~~-_/ |    |   ~\\_   _-~            /\\\n" +
                "#                           /  \\     \\__   \\/~                \\__\n" +
                "#                       _--~ _/ | .-~~____--~-/                  ~~==.\n" +
                "#                      ((->/~   '.|||' -_|    ~~-/ ,              . _||\n" +
                "#                                 -_     ~\\      ~~---l__i__i__i--~~_/\n" +
                "#                                 _-~-__   ~)  \\--______________--~~\n" +
                "#                               //.-~~~-~_--~- |-------~~~~~~~~\n" +
                "#                                      //.-~~~--\\\n" +
                "#                  千行代码\n" +
                "#                Bug何处藏!";

        String a8 = "#      ,----------------,              ,---------,\n" +
                "#         ,-----------------------,          ,\"        ,\"|\n" +
                "#       ,\"                      ,\"|        ,\"        ,\"  |\n" +
                "#      +-----------------------+  |      ,\"        ,\"    |\n" +
                "#      |  .-----------------.  |  |     +---------+      |\n" +
                "#      |  |                 |  |  |     | -==----'|      |\n" +
                "#      |  |  I LOVE JAVA!    |  |  |     |         |      |\n" +
                "#      |  |  Bad command or |  |  |/----|`---=    |      |\n" +
                "#      |  |  C:\\>_          |  |  |   ,/|==== ooo |      ;\n" +
                "#      |  |                 |  |  |  // |(((( [33]|    ,\"\n" +
                "#      |  `-----------------'  |,\" .;'| |((((     |  ,\"\n" +
                "#      +-----------------------+  ;;  | |         |,\"\n" +
                "#         /_)______________(_/  //'   | +---------+\n" +
                "#    ___________________________/___  `,\n" +
                "#   /  oooooooooooooooo  .o.  oooo /,   \\,\"-----------\n" +
                "#  / ==ooooooooooooooo==.o.  ooo= //   ,`\\--{)B     ,\"\n" +
                "# /_==__==========__==_ooo__ooo=_/'   /___________,\n" +
                "================写字楼里写字间，写字间里程序员=============";

        String a9 = "/**\n" +
                " * _ooOoo_\n" +
                " * o8888888o\n" +
                " * 88\" . \"88\n" +
                " * (| -_- |)\n" +
                " *  O\\ = /O\n" +
                " * ___/`---'\\____\n" +
                " * .   ' \\\\| |// `.\n" +
                " * / \\\\||| : |||// \\\n" +
                " * / _||||| -:- |||||- \\\n" +
                " * | | \\\\\\ - /// | |\n" +
                " * | \\_| ''\\---/'' | |\n" +
                " * \\ .-\\__ `-` ___/-. /\n" +
                " * ___`. .' /--.--\\ `. . __\n" +
                " * .\"\" '< `.___\\_<|>_/___.' >'\"\".\n" +
                " * | | : `- \\`.;`\\ _ /`;.`/ - ` : | |\n" +
                " * \\ \\ `-. \\_ __\\ /__ _/ .-` / /\n" +
                " * ======`-.____`-.___\\_____/___.-`____.-'======\n" +
                " * `=---='\n" +
                " *          .............................................\n" +
                " *           佛曰：bug泛滥，我已瘫痪！\n" +
                " */";

        String a10 = "        ´´´´´´´´██´´´´´´´\n" +
                "        ´´´´´´´████´´´´´´\n" +
                "        ´´´´´████████´´´´\n" +
                "        ´´`´███▒▒▒▒███´´´´´\n" +
                "        ´´´███▒●▒▒●▒██´´´\n" +
                "        ´´´███▒▒▒▒▒▒██´´´´´\n" +
                "        ´´´███▒▒▒▒██´                      \n" +
                "        ´´██████▒▒███´´´´´                 \n" +
                "        ´██████▒▒▒▒███´´                   \n" +
                "        ██████▒▒▒▒▒▒███´´´´                \n" +
                "        ´´▓▓▓▓▓▓▓▓▓▓▓▓▓▒´´                 \n" +
                "        ´´▒▒▒▒▓▓▓▓▓▓▓▓▓▒´´´´´             \n" +
                "        ´.▒▒▒´´▓▓▓▓▓▓▓▓▒´´´´´            \n" +
                "        ´.▒▒´´´´▓▓▓▓▓▓▓▒                   \n" +
                "        ..▒▒.´´´´▓▓▓▓▓▓▓▒                  \n" +
                "        ´▒▒▒▒▒▒▒▒▒▒▒▒                     \n" +
                "        ´´´´´´´´´███████´´´´´              \n" +
                "        ´´´´´´´´████████´´´´´´´\n" +
                "        ´´´´´´´█████████´´´´´´\n" +
                "        ´´´´´´██████████´´´´             \n" +
                "        ´´´´´´██████████´´´              \n" +
                "        ´´´´´´´█████████´´\n" +
                "        ´´´´´´´█████████´´´\n" +
                "        ´´´´´´´´████████´´´´´\n" +
                "        ________▒▒▒▒▒\n" +
                "        _________▒▒▒▒\n" +
                "        _________▒▒▒▒\n" +
                "        ________▒▒_▒▒\n" +
                "        _______▒▒__▒▒\n" +
                "        _____ ▒▒___▒▒\n" +
                "        _____▒▒___▒▒\n" +
                "        ____▒▒____▒▒\n" +
                "        ___▒▒_____▒▒\n" +
                "        ███____ ▒▒\n" +
                "        ████____███\n" +
                "        █ _███_ _█_███\n" +
                "——————————————————————————女神保佑，代码无bug——————————————————————";

        String a11 = "#                  ___====-_  _-====___\n" +
                "#            _--^^^#####//      \\\\#####^^^--_\n" +
                "#         _-^##########// (    ) \\\\##########^-_\n" +
                "#        -############//  |\\^^/|  \\\\############-\n" +
                "#      _/############//   (@::@)   \\\\############\\_\n" +
                "#     /#############((     \\\\//     ))#############\\\n" +
                "#    -###############\\\\    (oo)    //###############-\n" +
                "#   -#################\\\\  / VV \\  //#################-\n" +
                "#  -###################\\\\/      \\//###################-\n" +
                "# _#/|##########/\\######(   /\\   )######/\\##########|\\#_\n" +
                "# |/ |#/\\#/\\#/\\/  \\#/\\##\\  |  |  /##/\\#/  \\/\\#/\\#/\\#| \\|\n" +
                "# `  |/  V  V  `   V  \\#\\| |  | |/#/  V   '  V  V  \\|  '\n" +
                "#    `   `  `      `   / | |  | | \\   '      '  '   '\n" +
                "#                     (  | |  | |  )\n" +
                "#                    __\\ | |  | | /__\n" +
                "#                   (vvv(VVV)(VVV)vvv)\n" +
                "#                   奔驰宝马贵者趣\n" +
                "#                公交自行程序员!";

        String a12 = "                              _.._        ,------------.\n" +
                "                           ,'      `.    (I want you! )\n" +
                "                          /  __) __` \\    `-,----------'\n" +
                "                         (  (`-`(-')  ) _.-'\n" +
                "                         /)  \\  = /  (\n" +
                "                        /'    |--' .  \\\n" +
                "                       (  ,---|  `-.)__`\n" +
                "                        )(  `-.,--'   _`-.\n" +
                "                       '/,'          (  Uu\",\n" +
                "                        (_       ,    `/,-' )\n" +
                "                        `.__,  : `-'/  /`--'\n" +
                "                          |     `--'  |\n" +
                "                          `   `-._   /\n" +
                "                           \\        (\n" +
                "                           /\\ .      \\.  \n" +
                "                          / |` \\     ,-\\\n" +
                "                         /  \\| .)   /   \\\n" +
                "                        ( ,'|\\    ,'     :\n" +
                "                        | \\,`.`--\"/      }\n" +
                "                        `,'    \\  |,'    /\n" +
                "                       / \"-._   `-/      |\n" +
                "                       \"-.   \"-.,'|     ;\n" +
                "                      /        _/[\"---'\"\"]\n" +
                "                     :        /  |\"-     '\n" +
                "                     '           |      /\n" +
                "                                 `      |";

        String a13 = "/**\n" +
                " * ┌───┐   ┌───┬───┬───┬───┐ ┌───┬───┬───┬───┐ ┌───┬───┬───┬───┐ ┌───┬───┬───┐\n" +
                " * │Esc│   │ F1│ F2│ F3│ F4│ │ F5│ F6│ F7│ F8│ │ F9│F10│F11│F12│ │P/S│S L│P/B│  ┌┐    ┌┐    ┌┐\n" +
                " * └───┘   └───┴───┴───┴───┘ └───┴───┴───┴───┘ └───┴───┴───┴───┘ └───┴───┴───┘  └┘    └┘    └┘\n" +
                " * ┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───────┐ ┌───┬───┬───┐ ┌───┬───┬───┬───┐\n" +
                " * │~ `│! 1│@ 2│# 3│$ 4│% 5│^ 6│& 7│* 8│( 9│) 0│_ -│+ =│ BacSp │ │Ins│Hom│PUp│ │N L│ / │ * │ - │\n" +
                " * ├───┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─────┤ ├───┼───┼───┤ ├───┼───┼───┼───┤\n" +
                " * │ Tab │ Q │ W │ E │ R │ T │ Y │ U │ I │ O │ P │{ [│} ]│ | \\ │ │Del│End│PDn│ │ 7 │ 8 │ 9 │   │\n" +
                " * ├─────┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴─────┤ └───┴───┴───┘ ├───┼───┼───┤ + │\n" +
                " * │ Caps │ A │ S │ D │ F │ G │ H │ J │ K │ L │: ;│\" '│ Enter  │               │ 4 │ 5 │ 6 │   │\n" +
                " * ├──────┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴────────┤     ┌───┐     ├───┼───┼───┼───┤\n" +
                " * │ Shift  │ Z │ X │ C │ V │ B │ N │ M │< ,│> .│? /│  Shift   │     │ ↑ │     │ 1 │ 2 │ 3 │   │\n" +
                " * ├─────┬──┴─┬─┴──┬┴───┴───┴───┴───┴───┴──┬┴───┼───┴┬────┬────┤ ┌───┼───┼───┐ ├───┴───┼───┤ E││\n" +
                " * │ Ctrl│    │Alt │         Space         │ Alt│    │    │Ctrl│ │ ← │ ↓ │ → │ │   0   │ . │←─┘│\n" +
                " * └─────┴────┴────┴───────────────────────┴────┴────┴────┴────┘ └───┴───┴───┘ └───────┴───┴───┘\n" +
                " */";
        String a14 = "/**\n" +
                " * 頂頂頂頂頂頂頂頂頂　頂頂頂頂頂頂頂頂頂\n" +
                " * 頂頂頂頂頂頂頂　　　　　頂頂　　　　　\n" +
                " * 　　　頂頂　　　頂頂頂頂頂頂頂頂頂頂頂\n" +
                " * 　　　頂頂　　　頂頂頂頂頂頂頂頂頂頂頂\n" +
                " * 　　　頂頂　　　頂頂　　　　　　　頂頂\n" +
                " * 　　　頂頂　　　頂頂　　頂頂頂　　頂頂\n" +
                " * 　　　頂頂　　　頂頂　　頂頂頂　　頂頂\n" +
                " * 　　　頂頂　　　頂頂　　頂頂頂　　頂頂\n" +
                " * 　　　頂頂　　　頂頂　　頂頂頂　　頂頂\n" +
                " * 　　　頂頂　　　　　　　頂頂頂　\n" +
                " * 　　　頂頂　　　　　　頂頂　頂頂　頂頂\n" +
                " * 　頂頂頂頂　　　頂頂頂頂頂　頂頂頂頂頂\n" +
                " * 　頂頂頂頂　　　頂頂頂頂　　　頂頂頂頂\n" +
                " */";

        String a15 = "//\n" +
                "//   █████▒█    ██  ▄████▄   ██ ▄█▀       ██████╗ ██╗   ██╗ ██████╗\n" +
                "// ▓██   ▒ ██  ▓██▒▒██▀ ▀█   ██▄█▒        ██╔══██╗██║   ██║██╔════╝\n" +
                "// ▒████ ░▓██  ▒██░▒▓█    ▄ ▓███▄░        ██████╔╝██║   ██║██║  ███╗\n" +
                "// ░▓█▒  ░▓▓█  ░██░▒▓▓▄ ▄██▒▓██ █▄        ██╔══██╗██║   ██║██║   ██║\n" +
                "// ░▒█░   ▒▒█████▓ ▒ ▓███▀ ░▒██▒ █▄       ██████╔╝╚██████╔╝╚██████╔╝\n" +
                "//  ▒ ░   ░▒▓▒ ▒ ▒ ░ ░▒ ▒  ░▒ ▒▒ ▓▒       ╚═════╝  ╚═════╝  ╚═════╝\n" +
                "//  ░     ░░▒░ ░ ░   ░  ▒   ░ ░▒ ▒░\n" +
                "//  ░ ░    ░░░ ░ ░ ░        ░ ░░ ░\n" +
                "//           ░     ░ ░      ░  ░\n" +
                "//                 ░";

        String[] strArr = {a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15};
        Random rand = new Random();
        return "\n" + strArr[rand.nextInt(strArr.length)];

    }
}
