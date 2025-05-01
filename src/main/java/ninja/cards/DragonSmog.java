package ninja.cards;

import ninja.actions.DragonSmogAction;
import ninja.actions.NinjutsuAction;
import ninja.Ninja;import ninja.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import ninja.Ninja;
import com.megacrit.cardcrawl.powers.IntangiblePlayerPower;
import com.megacrit.cardcrawl.vfx.combat.SmokeBombEffect;

public class DragonSmog extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("DragonSmog");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/DragonSmog.png";
    private static final int COST = 3;
    private static final int UPGRADE_PLUS_MAGIC = 2;
    public static final String ID = "DragonSmog";
    private static final int NINJUTSU = 3 ;

    public DragonSmog(){
        super (ID, NAME,Ninja.getResourcePath( IMG_PATH), COST, DESCRIPTION, CardType.SKILL, CardColorEnum.SILVER, CardRarity.RARE, CardTarget.SELF);
        this.baseMagicNumber = 3;
        this.magicNumber = this.baseMagicNumber;
        this.exhaust=true;
        this.tags.add(CardTags.NINJUTSU);
    }

    public void use(AbstractPlayer p, AbstractMonster m){
        AbstractCreature var2 = AbstractDungeon.player;
        this.addToBot(new ApplyPowerAction(p, p, new IntangiblePlayerPower(p, 1), 1));
        this.addToBot(new VFXAction(new SmokeBombEffect(var2.hb.cX, var2.hb.cY)));
        this.addToBot(new NinjutsuAction(p,new  DragonSmogAction(p , m ,this.magicNumber),NINJUTSU,"DragonSmog"));
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeMagicNumber(UPGRADE_PLUS_MAGIC);
            this.upgradeBaseCost(2);
        }
    }

    public AbstractCard makeCopy(){
        return new DragonSmog();
    }
}
