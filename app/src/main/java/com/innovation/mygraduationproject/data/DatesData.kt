package com.innovation.mygraduationproject.data

object DatesCatalog {

    val all: List<DateType> = listOf(
        DateType(
            id = "sukkari",
            nameAr = "تمر السكري",
            nameEn = "Sukkari Dates",

            regionAr = "منطقة القصيم – المملكة العربية السعودية",
            regionEn = "Al-Qassim – Saudi Arabia",

            generalDescAr = "تمر السكري من أشهر وأجود أنواع التمور في السعودية، يتميز بمذاقه الحلو وقوامه الطري ولونه الذهبي.",
            generalDescEn = "One of Saudi Arabia’s most popular premium dates, known for its sweet taste, soft texture, and golden color.",

            colorAr = "ذهبي مائل للبني",
            colorEn = "Golden to light brown",
            textureAr = "طري من الداخل مع قشرة خفيفة",
            textureEn = "Soft inside with a light skin",
            sizeAr = "متوسط إلى كبير",
            sizeEn = "Medium to large",

            freshnessTipsAr = listOf(
                "يكون خاليًا من الروائح الغريبة",
                "القشرة غير متشققة أو متيبسة",
                "الطعم متوازن غير لاذع"
            ),
            freshnessTipsEn = listOf(
                "No unusual odors",
                "Skin is not overly cracked or too dry",
                "Taste is balanced (not sour)"
            ),

            usesAr = listOf(
                "يؤكل طازجًا",
                "يستخدم مع القهوة العربية",
                "يدخل في الحلويات التقليدية",
                "مناسب للأطفال وكبار السن"
            ),
            usesEn = listOf(
                "Eaten fresh",
                "Served with Arabic coffee",
                "Used in traditional desserts",
                "Suitable for kids and seniors"
            ),

            nutrition = DateNutrition(
                caloriesKcal = 280,
                carbsPercent = 75,
                fiberPercent = 7,
                minerals = "Potassium, Magnesium"
            ),

            imageResName = "sukkari"
        ),
        DateType(
            id = "barhi",
            nameAr = "تمر البرحي",
            nameEn = "Barhi Dates",

            regionAr = "القصيم ومناطق زراعية متعددة – السعودية",
            regionEn = "Al-Qassim & multiple farming areas – Saudi Arabia",

            generalDescAr = "البرحي مشهور بطعمه السكري وقوامه الناعم، ويؤكل كثيرًا في مرحلة الرطب أو نصف الجاف.",
            generalDescEn = "Barhi is famous for its very sweet taste and smooth texture, often eaten as rutab or semi-dry.",

            colorAr = "أصفر ذهبي إلى كهرماني",
            colorEn = "Yellow-golden to amber",
            textureAr = "ناعم جدًا وقد يكون لزج قليلًا",
            textureEn = "Very soft, slightly sticky",
            sizeAr = "متوسط",
            sizeEn = "Medium",

            freshnessTipsAr = listOf(
                "لا يوجد تخمر أو رائحة حامضة",
                "التمر متماسك وليس مهروس",
                "اللون طبيعي بدون بقع سوداء كثيرة"
            ),
            freshnessTipsEn = listOf(
                "No fermentation or sour smell",
                "Not mashed; holds its shape",
                "Natural color without many dark spots"
            ),

            usesAr = listOf(
                "يؤكل طازجًا (خصوصًا رطب)",
                "يقدم مع القهوة والشاي",
                "يدخل في صوصات الحلى أو العصائر"
            ),
            usesEn = listOf(
                "Eaten fresh (especially as rutab)",
                "Served with coffee or tea",
                "Used in dessert sauces or smoothies"
            ),

            nutrition = DateNutrition(
                caloriesKcal = 270,
                carbsPercent = 72,
                fiberPercent = 6,
                minerals = "Potassium, Iron"
            ),

            imageResName = "barhi"
        ),
        DateType(
            id = "khalas",
            nameAr = "تمر الخلاص",
            nameEn = "Khalas Dates",

            regionAr = "الأحساء – المنطقة الشرقية (السعودية)",
            regionEn = "Al-Ahsa – Eastern Province (Saudi Arabia)",

            generalDescAr = "الخلاص من أشهر تمور الضيافة، طعمه متوازن بين الحلاوة والنعومة، ويُعد خيارًا كلاسيكيًا مع القهوة.",
            generalDescEn = "A classic hospitality date with a balanced sweetness and soft bite — a perfect match for Arabic coffee.",

            colorAr = "كهرماني إلى بني فاتح",
            colorEn = "Amber to light brown",
            textureAr = "طري متوسط (غير مفرط)",
            textureEn = "Medium-soft (not overly mushy)",
            sizeAr = "متوسط",
            sizeEn = "Medium",

            freshnessTipsAr = listOf(
                "التمر غير جاف جدًا ولا لزج بشكل مبالغ",
                "بدون رائحة غريبة",
                "القشرة ناعمة ومتجانسة"
            ),
            freshnessTipsEn = listOf(
                "Not too dry or overly sticky",
                "No off smell",
                "Smooth and even skin"
            ),

            usesAr = listOf(
                "للضيافة مع القهوة العربية",
                "سناك يومي",
                "يدخل في حلى التمر"
            ),
            usesEn = listOf(
                "Hospitality with Arabic coffee",
                "Daily snack",
                "Used in date-based desserts"
            ),

            nutrition = DateNutrition(
                caloriesKcal = 285,
                carbsPercent = 74,
                fiberPercent = 7,
                minerals = "Potassium, Magnesium"
            ),

            imageResName = "khalas"
        ),
        DateType(
            id = "ajwa",
            nameAr = "تمر عجوة المدينة",
            nameEn = "Ajwa (Madinah) Dates",

            regionAr = "المدينة المنورة – المملكة العربية السعودية",
            regionEn = "Madinah – Saudi Arabia",

            generalDescAr = "العجوة من أشهر تمور المدينة، لونها داكن وطعمها مميز وقوامها ناعم، وغالبًا تُقدم كهدايا فاخرة.",
            generalDescEn = "Ajwa is a famous Madinah date with a dark color, distinctive taste, and soft texture — often gifted as a premium date.",

            colorAr = "أسود إلى بني داكن",
            colorEn = "Black to dark brown",
            textureAr = "ناعمة وتميل للجفاف الخفيف حسب الجودة",
            textureEn = "Soft with slight dryness depending on quality",
            sizeAr = "صغير إلى متوسط",
            sizeEn = "Small to medium",

            freshnessTipsAr = listOf(
                "التمر متجانس بدون تكتل شديد",
                "لا يوجد طعم مر أو رائحة نفاذة",
                "ملمس معتدل غير قاسي"
            ),
            freshnessTipsEn = listOf(
                "Even texture without hard clumps",
                "No bitter taste or strong odor",
                "Moderately soft (not hard)"
            ),

            usesAr = listOf(
                "للضيافة والهدايا",
                "سناك صحي",
                "يدخل في خلطات الطاقة"
            ),
            usesEn = listOf(
                "Hospitality and gifting",
                "Healthy snack",
                "Used in energy mixes"
            ),

            nutrition = DateNutrition(
                caloriesKcal = 280,
                carbsPercent = 73,
                fiberPercent = 7,
                minerals = "Potassium, Calcium"
            ),

            imageResName = "ajwa"
        ),
        DateType(
            id = "wanah",
            nameAr = "تمر ونّانة",
            nameEn = "Wanah Dates",

            regionAr = "مناطق متعددة داخل السعودية",
            regionEn = "Multiple regions in Saudi Arabia",

            generalDescAr = "ونّانة تمر مناسب للاستخدام اليومي، بطعم حلو معتدل وقوام جيد، ويُستخدم كثيرًا في الحلويات والخلطات.",
            generalDescEn = "Wanah is a practical daily date with moderate sweetness and good texture, widely used in mixes and desserts.",

            colorAr = "بني متوسط",
            colorEn = "Medium brown",
            textureAr = "متوسط الطراوة",
            textureEn = "Medium-soft",
            sizeAr = "متوسط",
            sizeEn = "Medium",

            freshnessTipsAr = listOf(
                "لا يكون ناشف جدًا",
                "بدون سكر متبلور كثيف على السطح",
                "لا توجد روائح غريبة"
            ),
            freshnessTipsEn = listOf(
                "Not extremely dry",
                "No heavy sugar crystallization on the surface",
                "No unusual smell"
            ),

            usesAr = listOf(
                "للوجبات الخفيفة",
                "للمعمول والحلى",
                "خلطات المكسرات والتمر"
            ),
            usesEn = listOf(
                "Snacks",
                "Maamoul and desserts",
                "Nuts & date mixes"
            ),

            nutrition = DateNutrition(
                caloriesKcal = 275,
                carbsPercent = 73,
                fiberPercent = 7,
                minerals = "Potassium, Iron"
            ),

            imageResName = "wanah"
        ),
        DateType(
            id = "saqai",
            nameAr = "تمر الصقعي",
            nameEn = "Saqai Dates",

            regionAr = "منطقة القصيم – المملكة العربية السعودية",
            regionEn = "Al-Qassim – Saudi Arabia",

            generalDescAr = "الصقعي معروف بمظهره الجميل (ثنائي اللون غالبًا) وطعمه المتوازن، ويُعد خيارًا أنيقًا للتقديم.",
            generalDescEn = "Saqai is known for its elegant two-tone look and balanced sweetness — great for serving guests.",

            colorAr = "ثنائي اللون (فاتح مع أطراف أغمق)",
            colorEn = "Two-toned (light body with darker tips)",
            textureAr = "متوسط الطراوة",
            textureEn = "Medium-soft",
            sizeAr = "متوسط إلى كبير",
            sizeEn = "Medium to large",

            freshnessTipsAr = listOf(
                "اللون واضح ومتجانس بدون بقع غير طبيعية",
                "القوام غير جاف ولا شديد اللزوجة",
                "الرائحة طبيعية"
            ),
            freshnessTipsEn = listOf(
                "Clear, even color without odd spots",
                "Not too dry or overly sticky",
                "Natural smell"
            ),

            usesAr = listOf(
                "للضيافة",
                "سناك يومي",
                "ترتيب صواني التمر والهدايا"
            ),
            usesEn = listOf(
                "Hospitality",
                "Daily snack",
                "Gift/date trays"
            ),

            nutrition = DateNutrition(
                caloriesKcal = 285,
                carbsPercent = 75,
                fiberPercent = 7,
                minerals = "Potassium, Magnesium"
            ),

            imageResName = "saqai"
        ),
        DateType(
            id = "rutab",
            nameAr = "الرُّطب",
            nameEn = "Rutab (Fresh Dates)",

            regionAr = "عدة مناطق داخل السعودية (حسب الموسم)",
            regionEn = "Various regions in Saudi Arabia (seasonal)",

            generalDescAr = "الرطب هو مرحلة نضج طازجة قبل الجفاف الكامل، قوامه لين جدًا وطعمه حلو ولطيف وغالبًا يُؤكل مباشرة.",
            generalDescEn = "Rutab is the fresh ripening stage before full drying — very soft, sweet, and usually eaten fresh.",

            colorAr = "بني طري (حسب النوع)",
            colorEn = "Soft brown (varies by type)",
            textureAr = "لين جدًا وعالي الرطوبة",
            textureEn = "Very soft and moist",
            sizeAr = "متفاوت حسب النوع",
            sizeEn = "Varies by type",

            freshnessTipsAr = listOf(
                "يُحفظ بالثلاجة لأنه سريع التلف",
                "لا يكون لزج جدًا أو متخمر",
                "بدون رائحة حامضة"
            ),
            freshnessTipsEn = listOf(
                "Keep refrigerated (spoils faster)",
                "Not overly sticky or fermented",
                "No sour odor"
            ),

            usesAr = listOf(
                "يؤكل طازجًا",
                "مناسب للإفطار",
                "يخلط مع اللبن/الزبادي"
            ),
            usesEn = listOf(
                "Eaten fresh",
                "Great for breakfast",
                "Mixed with milk/yogurt"
            ),

            nutrition = DateNutrition(
                caloriesKcal = 200,
                carbsPercent = 54,
                fiberPercent = 6,
                minerals = "Potassium, Vitamin B6"
            ),

            imageResName = "rutab"
        ),
        DateType(
            id = "safawi",
            nameAr = "تمر الصفاوي",
            nameEn = "Safawi Dates",

            regionAr = "المدينة المنورة – المملكة العربية السعودية",
            regionEn = "Madinah – Saudi Arabia",

            generalDescAr = "الصفاوي تمر داكن اللون وناعم القوام، شائع جدًا في المدينة ومناسب للتخزين والضيافة.",
            generalDescEn = "Safawi is a dark date with soft texture, popular in Madinah and suitable for storage and hospitality.",

            colorAr = "أسود مائل للبني",
            colorEn = "Dark brown/black",
            textureAr = "طري وناعم",
            textureEn = "Soft and smooth",
            sizeAr = "متوسط",
            sizeEn = "Medium",

            freshnessTipsAr = listOf(
                "يكون لامع قليلًا بدون رطوبة زائدة",
                "لا يوجد طعم حامض",
                "القوام متماسك وليس متفتت"
            ),
            freshnessTipsEn = listOf(
                "Slight natural shine without excess moisture",
                "No sour taste",
                "Firm-soft (not crumbly)"
            ),

            usesAr = listOf(
                "للضيافة",
                "للوجبات الخفيفة",
                "يستخدم في خلطات التمر"
            ),
            usesEn = listOf(
                "Hospitality",
                "Snacks",
                "Date mixes"
            ),

            nutrition = DateNutrition(
                caloriesKcal = 290,
                carbsPercent = 76,
                fiberPercent = 7,
                minerals = "Potassium, Magnesium"
            ),

            imageResName = "safawi"
        ),
        DateType(
            id = "anbara",
            nameAr = "تمر العنبرة",
            nameEn = "Anbara Dates",

            regionAr = "المدينة المنورة – المملكة العربية السعودية",
            regionEn = "Madinah – Saudi Arabia",

            generalDescAr = "العنبرة من التمور الفاخرة، غالبًا حجمها كبير وطعمها جميل، وتُستخدم كثيرًا كهدايا.",
            generalDescEn = "Anbara is a premium date, often large in size with a pleasant taste — commonly chosen for gifting.",

            colorAr = "بني محمر",
            colorEn = "Reddish brown",
            textureAr = "طري متوسط",
            textureEn = "Medium-soft",
            sizeAr = "كبير",
            sizeEn = "Large",

            freshnessTipsAr = listOf(
                "الحبة كبيرة ومتجانسة بدون انكماش واضح",
                "القشرة ناعمة غير قاسية",
                "لا توجد رائحة قوية غير طبيعية"
            ),
            freshnessTipsEn = listOf(
                "Large, even pieces without heavy shrinkage",
                "Skin is not tough",
                "No strong unusual smell"
            ),

            usesAr = listOf(
                "الهدايا والضيافة الفاخرة",
                "سناك عالي الطاقة",
                "تقديمه في المناسبات"
            ),
            usesEn = listOf(
                "Premium gifting and hospitality",
                "High-energy snack",
                "Occasion serving"
            ),

            nutrition = DateNutrition(
                caloriesKcal = 295,
                carbsPercent = 77,
                fiberPercent = 7,
                minerals = "Potassium, Iron"
            ),

            imageResName = "anbara"
        ),
    )
    fun byId(id: String): DateType? = all.firstOrNull { it.id == id }
}