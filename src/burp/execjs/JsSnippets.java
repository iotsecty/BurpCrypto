package burp.execjs;

import java.util.HashMap;

public class JsSnippets {
    public static HashMap<String, String> SnippetHelps = new HashMap<String,String>() {{
       put("Base64",
               "\r\n/* \n" +
                   " * Base64 example:\n" +
                   " * base64.encode('admin');\n" +
                   " * > YWRtaW4=\n" +
                   " * base64.decode('YWRtaW4=');\n" +
                   " * > admin\n" +
                   " */");
        put("MD5",
                "\r\n/* \n" +
                    " * MD5 example:\n" +
                    " * hex_md5('123456');\n" +
                    " * > e10adc3949ba59abbe56e057f20f883e\n" +
                    " * b64_md5('123456');\n" +
                    " * > 4QrcOUm6Wau+VuBX8g+IPg\n" +
                    " */");
    }};
    public static HashMap<String, String> Snippets = new HashMap<String, String>() {{
            put("Base64","function __b64() {  \n" +
                    "\n" +
                    "    // private property\n" +
                    "    _keyStr = \"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=\";  \n" +
                    "\n" +
                    "    // public method for encoding\n" +
                    "    this.encode = function (input) {  \n" +
                    "        var output = \"\";  \n" +
                    "        var chr1, chr2, chr3, enc1, enc2, enc3, enc4;  \n" +
                    "        var i = 0;  \n" +
                    "        input = _utf8_encode(input);  \n" +
                    "        while (i < input.length) {  \n" +
                    "            chr1 = input.charCodeAt(i++);  \n" +
                    "            chr2 = input.charCodeAt(i++);  \n" +
                    "            chr3 = input.charCodeAt(i++);  \n" +
                    "            enc1 = chr1 >> 2;  \n" +
                    "            enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);  \n" +
                    "            enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);  \n" +
                    "            enc4 = chr3 & 63;  \n" +
                    "            if (isNaN(chr2)) {  \n" +
                    "                enc3 = enc4 = 64;  \n" +
                    "            } else if (isNaN(chr3)) {  \n" +
                    "                enc4 = 64;  \n" +
                    "            }  \n" +
                    "            output = output +  \n" +
                    "            _keyStr.charAt(enc1) + _keyStr.charAt(enc2) +  \n" +
                    "            _keyStr.charAt(enc3) + _keyStr.charAt(enc4);  \n" +
                    "        }  \n" +
                    "        return output;  \n" +
                    "    }  \n" +
                    "\n" +
                    "    // public method for decoding\n" +
                    "    this.decode = function (input) {  \n" +
                    "        var output = \"\";  \n" +
                    "        var chr1, chr2, chr3;  \n" +
                    "        var enc1, enc2, enc3, enc4;  \n" +
                    "        var i = 0;  \n" +
                    "        input = input.replace(/[^A-Za-z0-9\\+\\/\\=]/g, \"\");  \n" +
                    "        while (i < input.length) {  \n" +
                    "            enc1 = _keyStr.indexOf(input.charAt(i++));  \n" +
                    "            enc2 = _keyStr.indexOf(input.charAt(i++));  \n" +
                    "            enc3 = _keyStr.indexOf(input.charAt(i++));  \n" +
                    "            enc4 = _keyStr.indexOf(input.charAt(i++));  \n" +
                    "            chr1 = (enc1 << 2) | (enc2 >> 4);  \n" +
                    "            chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);  \n" +
                    "            chr3 = ((enc3 & 3) << 6) | enc4;  \n" +
                    "            output = output + String.fromCharCode(chr1);  \n" +
                    "            if (enc3 != 64) {  \n" +
                    "                output = output + String.fromCharCode(chr2);  \n" +
                    "            }  \n" +
                    "            if (enc4 != 64) {  \n" +
                    "                output = output + String.fromCharCode(chr3);  \n" +
                    "            }  \n" +
                    "        }  \n" +
                    "        output = _utf8_decode(output);  \n" +
                    "        return output;  \n" +
                    "    }  \n" +
                    "\n" +
                    "    // private method for UTF-8 encoding\n" +
                    "    _utf8_encode = function (string) {  \n" +
                    "        string = string.replace(/\\r\\n/g,\"\\n\");  \n" +
                    "        var utftext = \"\";  \n" +
                    "        for (var n = 0; n < string.length; n++) {  \n" +
                    "            var c = string.charCodeAt(n);  \n" +
                    "            if (c < 128) {  \n" +
                    "                utftext += String.fromCharCode(c);  \n" +
                    "            } else if((c > 127) && (c < 2048)) {  \n" +
                    "                utftext += String.fromCharCode((c >> 6) | 192);  \n" +
                    "                utftext += String.fromCharCode((c & 63) | 128);  \n" +
                    "            } else {  \n" +
                    "                utftext += String.fromCharCode((c >> 12) | 224);  \n" +
                    "                utftext += String.fromCharCode(((c >> 6) & 63) | 128);  \n" +
                    "                utftext += String.fromCharCode((c & 63) | 128);  \n" +
                    "            }  \n" +
                    "\n" +
                    "        }  \n" +
                    "        return utftext;  \n" +
                    "    }  \n" +
                    "\n" +
                    "    // private method for UTF-8 decoding\n" +
                    "    _utf8_decode = function (utftext) {  \n" +
                    "        var string = \"\";  \n" +
                    "        var i = 0;  \n" +
                    "        var c = c1 = c2 = 0;  \n" +
                    "        while ( i < utftext.length ) {  \n" +
                    "            c = utftext.charCodeAt(i);  \n" +
                    "            if (c < 128) {  \n" +
                    "                string += String.fromCharCode(c);  \n" +
                    "                i++;  \n" +
                    "            } else if((c > 191) && (c < 224)) {  \n" +
                    "                c2 = utftext.charCodeAt(i+1);  \n" +
                    "                string += String.fromCharCode(((c & 31) << 6) | (c2 & 63));  \n" +
                    "                i += 2;  \n" +
                    "            } else {  \n" +
                    "                c2 = utftext.charCodeAt(i+1);  \n" +
                    "                c3 = utftext.charCodeAt(i+2);  \n" +
                    "                string += String.fromCharCode(((c & 15) << 12) | ((c2 & 63) << 6) | (c3 & 63));  \n" +
                    "                i += 3;  \n" +
                    "            }  \n" +
                    "        }  \n" +
                    "        return string;  \n" +
                    "    }  \n" +
                    "}\n" +
                    "var base64 = new __b64();");
            put("MD5","var hexcase = 0;\n" +
                    "var b64pad = \"\";\n" +
                    "var chrsz = 8;\n" +
                    "function hex_md5(s) {\n" +
                    "    return binl2hex(core_md5(str2binl(s), s.length * chrsz))\n" +
                    "}\n" +
                    "function b64_md5(s) {\n" +
                    "    return binl2b64(core_md5(str2binl(s), s.length * chrsz))\n" +
                    "}\n" +
                    "function str_md5(s) {\n" +
                    "    return binl2str(core_md5(str2binl(s), s.length * chrsz))\n" +
                    "}\n" +
                    "function hex_hmac_md5(key, data) {\n" +
                    "    return binl2hex(core_hmac_md5(key, data))\n" +
                    "}\n" +
                    "function b64_hmac_md5(key, data) {\n" +
                    "    return binl2b64(core_hmac_md5(key, data))\n" +
                    "}\n" +
                    "function str_hmac_md5(key, data) {\n" +
                    "    return binl2str(core_hmac_md5(key, data))\n" +
                    "}\n" +
                    "function md5_vm_test() {\n" +
                    "    return hex_md5(\"abc\") == \"900150983cd24fb0d6963f7d28e17f72\"\n" +
                    "}\n" +
                    "function core_md5(x, len) {\n" +
                    "    x[len >> 5] |= 0x80 << ((len) % 32);\n" +
                    "    x[(((len + 64) >>> 9) << 4) + 14] = len;\n" +
                    "    var a = 1732584193;\n" +
                    "    var b = -271733879;\n" +
                    "    var c = -1732584194;\n" +
                    "    var d = 271733878;\n" +
                    "    for (var i = 0; i < x.length; i += 16) {\n" +
                    "        var olda = a;\n" +
                    "        var oldb = b;\n" +
                    "        var oldc = c;\n" +
                    "        var oldd = d;\n" +
                    "        a = md5_ff(a, b, c, d, x[i + 0], 7, -680876936);\n" +
                    "        d = md5_ff(d, a, b, c, x[i + 1], 12, -389564586);\n" +
                    "        c = md5_ff(c, d, a, b, x[i + 2], 17, 606105819);\n" +
                    "        b = md5_ff(b, c, d, a, x[i + 3], 22, -1044525330);\n" +
                    "        a = md5_ff(a, b, c, d, x[i + 4], 7, -176418897);\n" +
                    "        d = md5_ff(d, a, b, c, x[i + 5], 12, 1200080426);\n" +
                    "        c = md5_ff(c, d, a, b, x[i + 6], 17, -1473231341);\n" +
                    "        b = md5_ff(b, c, d, a, x[i + 7], 22, -45705983);\n" +
                    "        a = md5_ff(a, b, c, d, x[i + 8], 7, 1770035416);\n" +
                    "        d = md5_ff(d, a, b, c, x[i + 9], 12, -1958414417);\n" +
                    "        c = md5_ff(c, d, a, b, x[i + 10], 17, -42063);\n" +
                    "        b = md5_ff(b, c, d, a, x[i + 11], 22, -1990404162);\n" +
                    "        a = md5_ff(a, b, c, d, x[i + 12], 7, 1804603682);\n" +
                    "        d = md5_ff(d, a, b, c, x[i + 13], 12, -40341101);\n" +
                    "        c = md5_ff(c, d, a, b, x[i + 14], 17, -1502002290);\n" +
                    "        b = md5_ff(b, c, d, a, x[i + 15], 22, 1236535329);\n" +
                    "        a = md5_gg(a, b, c, d, x[i + 1], 5, -165796510);\n" +
                    "        d = md5_gg(d, a, b, c, x[i + 6], 9, -1069501632);\n" +
                    "        c = md5_gg(c, d, a, b, x[i + 11], 14, 643717713);\n" +
                    "        b = md5_gg(b, c, d, a, x[i + 0], 20, -373897302);\n" +
                    "        a = md5_gg(a, b, c, d, x[i + 5], 5, -701558691);\n" +
                    "        d = md5_gg(d, a, b, c, x[i + 10], 9, 38016083);\n" +
                    "        c = md5_gg(c, d, a, b, x[i + 15], 14, -660478335);\n" +
                    "        b = md5_gg(b, c, d, a, x[i + 4], 20, -405537848);\n" +
                    "        a = md5_gg(a, b, c, d, x[i + 9], 5, 568446438);\n" +
                    "        d = md5_gg(d, a, b, c, x[i + 14], 9, -1019803690);\n" +
                    "        c = md5_gg(c, d, a, b, x[i + 3], 14, -187363961);\n" +
                    "        b = md5_gg(b, c, d, a, x[i + 8], 20, 1163531501);\n" +
                    "        a = md5_gg(a, b, c, d, x[i + 13], 5, -1444681467);\n" +
                    "        d = md5_gg(d, a, b, c, x[i + 2], 9, -51403784);\n" +
                    "        c = md5_gg(c, d, a, b, x[i + 7], 14, 1735328473);\n" +
                    "        b = md5_gg(b, c, d, a, x[i + 12], 20, -1926607734);\n" +
                    "        a = md5_hh(a, b, c, d, x[i + 5], 4, -378558);\n" +
                    "        d = md5_hh(d, a, b, c, x[i + 8], 11, -2022574463);\n" +
                    "        c = md5_hh(c, d, a, b, x[i + 11], 16, 1839030562);\n" +
                    "        b = md5_hh(b, c, d, a, x[i + 14], 23, -35309556);\n" +
                    "        a = md5_hh(a, b, c, d, x[i + 1], 4, -1530992060);\n" +
                    "        d = md5_hh(d, a, b, c, x[i + 4], 11, 1272893353);\n" +
                    "        c = md5_hh(c, d, a, b, x[i + 7], 16, -155497632);\n" +
                    "        b = md5_hh(b, c, d, a, x[i + 10], 23, -1094730640);\n" +
                    "        a = md5_hh(a, b, c, d, x[i + 13], 4, 681279174);\n" +
                    "        d = md5_hh(d, a, b, c, x[i + 0], 11, -358537222);\n" +
                    "        c = md5_hh(c, d, a, b, x[i + 3], 16, -722521979);\n" +
                    "        b = md5_hh(b, c, d, a, x[i + 6], 23, 76029189);\n" +
                    "        a = md5_hh(a, b, c, d, x[i + 9], 4, -640364487);\n" +
                    "        d = md5_hh(d, a, b, c, x[i + 12], 11, -421815835);\n" +
                    "        c = md5_hh(c, d, a, b, x[i + 15], 16, 530742520);\n" +
                    "        b = md5_hh(b, c, d, a, x[i + 2], 23, -995338651);\n" +
                    "        a = md5_ii(a, b, c, d, x[i + 0], 6, -198630844);\n" +
                    "        d = md5_ii(d, a, b, c, x[i + 7], 10, 1126891415);\n" +
                    "        c = md5_ii(c, d, a, b, x[i + 14], 15, -1416354905);\n" +
                    "        b = md5_ii(b, c, d, a, x[i + 5], 21, -57434055);\n" +
                    "        a = md5_ii(a, b, c, d, x[i + 12], 6, 1700485571);\n" +
                    "        d = md5_ii(d, a, b, c, x[i + 3], 10, -1894986606);\n" +
                    "        c = md5_ii(c, d, a, b, x[i + 10], 15, -1051523);\n" +
                    "        b = md5_ii(b, c, d, a, x[i + 1], 21, -2054922799);\n" +
                    "        a = md5_ii(a, b, c, d, x[i + 8], 6, 1873313359);\n" +
                    "        d = md5_ii(d, a, b, c, x[i + 15], 10, -30611744);\n" +
                    "        c = md5_ii(c, d, a, b, x[i + 6], 15, -1560198380);\n" +
                    "        b = md5_ii(b, c, d, a, x[i + 13], 21, 1309151649);\n" +
                    "        a = md5_ii(a, b, c, d, x[i + 4], 6, -145523070);\n" +
                    "        d = md5_ii(d, a, b, c, x[i + 11], 10, -1120210379);\n" +
                    "        c = md5_ii(c, d, a, b, x[i + 2], 15, 718787259);\n" +
                    "        b = md5_ii(b, c, d, a, x[i + 9], 21, -343485551);\n" +
                    "        a = safe_add(a, olda);\n" +
                    "        b = safe_add(b, oldb);\n" +
                    "        c = safe_add(c, oldc);\n" +
                    "        d = safe_add(d, oldd)\n" +
                    "    }\n" +
                    "    return Array(a, b, c, d)\n" +
                    "}\n" +
                    "function md5_cmn(q, a, b, x, s, t) {\n" +
                    "    return safe_add(bit_rol(safe_add(safe_add(a, q), safe_add(x, t)), s), b)\n" +
                    "}\n" +
                    "function md5_ff(a, b, c, d, x, s, t) {\n" +
                    "    return md5_cmn((b & c) | ((~b) & d), a, b, x, s, t)\n" +
                    "}\n" +
                    "function md5_gg(a, b, c, d, x, s, t) {\n" +
                    "    return md5_cmn((b & d) | (c & (~d)), a, b, x, s, t)\n" +
                    "}\n" +
                    "function md5_hh(a, b, c, d, x, s, t) {\n" +
                    "    return md5_cmn(b ^ c ^ d, a, b, x, s, t)\n" +
                    "}\n" +
                    "function md5_ii(a, b, c, d, x, s, t) {\n" +
                    "    return md5_cmn(c ^ (b | (~d)), a, b, x, s, t)\n" +
                    "}\n" +
                    "function core_hmac_md5(key, data) {\n" +
                    "    var bkey = str2binl(key);\n" +
                    "    if (bkey.length > 16) bkey = core_md5(bkey, key.length * chrsz);\n" +
                    "    var ipad = Array(16),\n" +
                    "    opad = Array(16);\n" +
                    "    for (var i = 0; i < 16; i++) {\n" +
                    "        ipad[i] = bkey[i] ^ 0x36363636;\n" +
                    "        opad[i] = bkey[i] ^ 0x5C5C5C5C\n" +
                    "    }\n" +
                    "    var hash = core_md5(ipad.concat(str2binl(data)), 512 + data.length * chrsz);\n" +
                    "    return core_md5(opad.concat(hash), 512 + 128)\n" +
                    "}\n" +
                    "function safe_add(x, y) {\n" +
                    "    var lsw = (x & 0xFFFF) + (y & 0xFFFF);\n" +
                    "    var msw = (x >> 16) + (y >> 16) + (lsw >> 16);\n" +
                    "    return (msw << 16) | (lsw & 0xFFFF)\n" +
                    "}\n" +
                    "function bit_rol(num, cnt) {\n" +
                    "    return (num << cnt) | (num >>> (32 - cnt))\n" +
                    "}\n" +
                    "function str2binl(str) {\n" +
                    "    var bin = Array();\n" +
                    "    var mask = (1 << chrsz) - 1;\n" +
                    "    for (var i = 0; i < str.length * chrsz; i += chrsz) bin[i >> 5] |= (str.charCodeAt(i / chrsz) & mask) << (i % 32);\n" +
                    "    return bin\n" +
                    "}\n" +
                    "function binl2str(bin) {\n" +
                    "    var str = \"\";\n" +
                    "    var mask = (1 << chrsz) - 1;\n" +
                    "    for (var i = 0; i < bin.length * 32; i += chrsz) str += String.fromCharCode((bin[i >> 5] >>> (i % 32)) & mask);\n" +
                    "    return str\n" +
                    "}\n" +
                    "function binl2hex(binarray) {\n" +
                    "    var hex_tab = hexcase ? \"0123456789ABCDEF\": \"0123456789abcdef\";\n" +
                    "    var str = \"\";\n" +
                    "    for (var i = 0; i < binarray.length * 4; i++) {\n" +
                    "        str += hex_tab.charAt((binarray[i >> 2] >> ((i % 4) * 8 + 4)) & 0xF) + hex_tab.charAt((binarray[i >> 2] >> ((i % 4) * 8)) & 0xF)\n" +
                    "    }\n" +
                    "    return str\n" +
                    "}\n" +
                    "function binl2b64(binarray) {\n" +
                    "    var tab = \"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/\";\n" +
                    "    var str = \"\";\n" +
                    "    for (var i = 0; i < binarray.length * 4; i += 3) {\n" +
                    "        var triplet = (((binarray[i >> 2] >> 8 * (i % 4)) & 0xFF) << 16) | (((binarray[i + 1 >> 2] >> 8 * ((i + 1) % 4)) & 0xFF) << 8) | ((binarray[i + 2 >> 2] >> 8 * ((i + 2) % 4)) & 0xFF);\n" +
                    "        for (var j = 0; j < 4; j++) {\n" +
                    "            if (i * 8 + j * 6 > binarray.length * 32) str += b64pad;\n" +
                    "            else str += tab.charAt((triplet >> 6 * (3 - j)) & 0x3F)\n" +
                    "        }\n" +
                    "    }\n" +
                    "    return str\n" +
                    "}");
        }};
    public static String EmptyFunction =
            "\r\n" +
            "function calc(pass) {\n" +
            "    return pass;\n" +
            "}\r\n";
}
