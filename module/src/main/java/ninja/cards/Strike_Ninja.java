package ninja.cards;

import static ninja.Ninja.getResourcePath;

import ninja.Ninja;
import ninja.enums.CardColorEnum;

import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static ninja.Ninja.getResourcePath;

import ninja.Ninja;

public class Strike_Ninja extends CustomCard {
    //从.json文件中提取键名为Strike_Ninja的信息
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Strike_Ninja");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/Strike.png";
    private static final int COST = 1;
    private static final int ATTACK_DMG = 6;
    private static final int UPGRADE_PLUS_DMG = 3;
    public static final String ID = "Strike_Ninja";

    //调用父类的构造方法，传参为super(卡牌ID,卡牌名称，能量花费，卡牌描述，卡牌类型，卡牌颜色，卡牌稀有度，卡牌目标)
    public Strike_Ninja() {
        super(ID, NAME, Ninja.getResourcePath(IMG_PATH), COST, DESCRIPTION, CardType.ATTACK, CardColorEnum.SILVER, CardRarity.BASIC, CardTarget.ENEMY);
        //添加基础攻击标签和将伤害设为6
        this.tags.add(CardTags.STARTER_STRIKE);
        this.tags.add(CardTags.STRIKE);
        this.baseDamage = ATTACK_DMG;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        CardCrawlGame.sound.play("Hia");
        //使用卡牌时触发的动作
        AbstractDungeon.actionManager.addToBottom(
                new DamageAction(
                        m,
                        new DamageInfo(
                                p,
                                this.damage,
                                DamageInfo.DamageType.NORMAL
                        ),
                        AbstractGameAction.AttackEffect.BLUNT_LIGHT
                )
        );
    }

    @Override

    public AbstractCard makeCopy() {
        //复制卡牌时触发
        return new Strike_Ninja();
    }


    @Override
    public void upgrade() {
        //卡牌升级后的效果
        if (!this.upgraded) {
            //更改名字和提高3点伤害
            upgradeName();
            upgradeDamage(UPGRADE_PLUS_DMG);
        }
    }
}