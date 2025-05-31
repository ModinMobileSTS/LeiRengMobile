package ninja.cards;

import ninja.actions.ScienceAction;
import static ninja.Ninja.getResourcePath;import ninja.Ninja;import ninja.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import static ninja.Ninja.getResourcePath;import ninja.Ninja;
import com.megacrit.cardcrawl.powers.CorpseExplosionPower;
import com.megacrit.cardcrawl.powers.PoisonPower;

public class NamiYoyo extends CustomCard{
    //从.json文件中提取键名为NamiYoyo的信息
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("NamiYoyo");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/NamiYoyo.png";
    private static final int COST = 2;
    private static final int ATTACK_DMG = 11;
    private static final int UPGRADE_PLUS_DMG = 3;
    public static final String ID = "NamiYoyo";
    private static final int NINJUTSU = 3;
    //调用父类的构造方法，传参为super(卡牌ID,卡牌名称，能量花费，卡牌描述，卡牌类型，卡牌颜色，卡牌稀有度，卡牌目标)
    public NamiYoyo() {
        super(ID, NAME,Ninja.getResourcePath( IMG_PATH), 4, DESCRIPTION, CardType.SKILL, CardColorEnum.SILVER, CardRarity.UNCOMMON, CardTarget.ENEMY);
        this.baseDamage = ATTACK_DMG;
        this.baseMagicNumber = 11;
        this.magicNumber = this.baseMagicNumber;
        this.tags.add(CardTags.SCIENCE);
    }

    @Override
    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeMagicNumber(3);
        }
    }

    @Override
    public void use(AbstractPlayer p,AbstractMonster m){
        CardCrawlGame.sound.play(ID);
        int count =0;
        this.addToTop(new ApplyPowerAction(m,p, new CorpseExplosionPower(m )));
        this.addToBot(new ApplyPowerAction(m , p ,new PoisonPower(m , p , this.magicNumber)));
        this.addToBot(new ScienceAction(p));
    }

    public AbstractCard makeCopy() {
        return new NamiYoyo();
    }
}
